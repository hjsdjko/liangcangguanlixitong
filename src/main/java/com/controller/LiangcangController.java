
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 粮仓
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/liangcang")
public class LiangcangController {
    private static final Logger logger = LoggerFactory.getLogger(LiangcangController.class);

    private static final String TABLE_NAME = "liangcang";

    @Autowired
    private LiangcangService liangcangService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private LiangcangChuruInoutService liangcangChuruInoutService;//出入库
    @Autowired
    private LiangcangChuruInoutListService liangcangChuruInoutListService;//出入库详情
    @Autowired
    private RenwuService renwuService;//出受粮任务
    @Autowired
    private YonghuService yonghuService;//粮仓保管员
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("粮仓保管员".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("liangcangDeleteStart",1);params.put("liangcangDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = liangcangService.queryPage(params);

        //字典表数据转换
        List<LiangcangView> list =(List<LiangcangView>)page.getList();
        for(LiangcangView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        LiangcangEntity liangcang = liangcangService.selectById(id);
        if(liangcang !=null){
            //entity转view
            LiangcangView view = new LiangcangView();
            BeanUtils.copyProperties( liangcang , view );//把实体数据重构到view中
            //级联表 粮仓保管员
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(liangcang.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody LiangcangEntity liangcang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,liangcang:{}",this.getClass().getName(),liangcang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("粮仓保管员".equals(role))
            liangcang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<LiangcangEntity> queryWrapper = new EntityWrapper<LiangcangEntity>()
            .eq("yonghu_id", liangcang.getYonghuId())
            .eq("liangcang_name", liangcang.getLiangcangName())
            .eq("liangcang_address", liangcang.getLiangcangAddress())
            .eq("liangcang_types", liangcang.getLiangcangTypes())
            .eq("liangcang_zuida_number", liangcang.getLiangcangZuidaNumber())
            .eq("liangcang_kucun_number", liangcang.getLiangcangKucunNumber())
            .eq("liangcang_hanchongliang", liangcang.getLiangcangHanchongliang())
            .eq("liangcang_shifou_types", liangcang.getLiangcangShifouTypes())
            .eq("liangcang_hanzalv", liangcang.getLiangcangHanzalv())
            .eq("liangcang_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LiangcangEntity liangcangEntity = liangcangService.selectOne(queryWrapper);
        if(liangcangEntity==null){
            liangcang.setLiangcangDelete(1);
            liangcang.setInsertTime(new Date());
            liangcang.setCreateTime(new Date());
            liangcangService.insert(liangcang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LiangcangEntity liangcang, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,liangcang:{}",this.getClass().getName(),liangcang.toString());
        LiangcangEntity oldLiangcangEntity = liangcangService.selectById(liangcang.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("粮仓保管员".equals(role))
//            liangcang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(liangcang.getLiangcangPhoto()) || "null".equals(liangcang.getLiangcangPhoto())){
                liangcang.setLiangcangPhoto(null);
        }

            liangcangService.updateById(liangcang);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<LiangcangEntity> oldLiangcangList =liangcangService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<LiangcangEntity> list = new ArrayList<>();
        for(Integer id:ids){
            LiangcangEntity liangcangEntity = new LiangcangEntity();
            liangcangEntity.setId(id);
            liangcangEntity.setLiangcangDelete(2);
            list.add(liangcangEntity);
        }
        if(list != null && list.size() >0){
            liangcangService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<LiangcangEntity> liangcangList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            LiangcangEntity liangcangEntity = new LiangcangEntity();
//                            liangcangEntity.setYonghuId(Integer.valueOf(data.get(0)));   //保管员 要改的
//                            liangcangEntity.setLiangcangName(data.get(0));                    //粮仓名称 要改的
//                            liangcangEntity.setLiangcangUuidNumber(data.get(0));                    //粮仓编号 要改的
//                            liangcangEntity.setLiangcangPhoto("");//详情和图片
//                            liangcangEntity.setLiangcangAddress(data.get(0));                    //粮仓地点 要改的
//                            liangcangEntity.setLiangcangTypes(Integer.valueOf(data.get(0)));   //水稻种型 要改的
//                            liangcangEntity.setLiangcangZuidaNumber(Integer.valueOf(data.get(0)));   //粮食最大容量 要改的
//                            liangcangEntity.setLiangcangKucunNumber(Integer.valueOf(data.get(0)));   //粮食现有量 要改的
//                            liangcangEntity.setLiangcangWendu(data.get(0));                    //当前温度 要改的
//                            liangcangEntity.setLiangcangShidu(data.get(0));                    //当前湿度 要改的
//                            liangcangEntity.setLiangcangHanchongliang(Integer.valueOf(data.get(0)));   //含虫量 要改的
//                            liangcangEntity.setLiangcangShifouTypes(Integer.valueOf(data.get(0)));   //是否喷射农药 要改的
//                            liangcangEntity.setLiangcangHanzalv(Integer.valueOf(data.get(0)));   //含杂率 要改的
//                            liangcangEntity.setLiangcangContent("");//详情和图片
//                            liangcangEntity.setLiangcangDelete(1);//逻辑删除字段
//                            liangcangEntity.setInsertTime(date);//时间
//                            liangcangEntity.setCreateTime(date);//时间
                            liangcangList.add(liangcangEntity);


                            //把要查询是否重复的字段放入map中
                                //粮仓编号
                                if(seachFields.containsKey("liangcangUuidNumber")){
                                    List<String> liangcangUuidNumber = seachFields.get("liangcangUuidNumber");
                                    liangcangUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> liangcangUuidNumber = new ArrayList<>();
                                    liangcangUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("liangcangUuidNumber",liangcangUuidNumber);
                                }
                        }

                        //查询是否重复
                         //粮仓编号
                        List<LiangcangEntity> liangcangEntities_liangcangUuidNumber = liangcangService.selectList(new EntityWrapper<LiangcangEntity>().in("liangcang_uuid_number", seachFields.get("liangcangUuidNumber")).eq("liangcang_delete", 1));
                        if(liangcangEntities_liangcangUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(LiangcangEntity s:liangcangEntities_liangcangUuidNumber){
                                repeatFields.add(s.getLiangcangUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [粮仓编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        liangcangService.insertBatch(liangcangList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




}

