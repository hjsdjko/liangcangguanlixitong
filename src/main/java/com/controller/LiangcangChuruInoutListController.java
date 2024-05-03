
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
 * 出入库详情
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/liangcangChuruInoutList")
public class LiangcangChuruInoutListController {
    private static final Logger logger = LoggerFactory.getLogger(LiangcangChuruInoutListController.class);

    private static final String TABLE_NAME = "liangcangChuruInoutList";

    @Autowired
    private LiangcangChuruInoutListService liangcangChuruInoutListService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private LiangcangService liangcangService;//粮仓
    @Autowired
    private LiangcangChuruInoutService liangcangChuruInoutService;//出入库
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
        CommonUtil.checkMap(params);
        PageUtils page = liangcangChuruInoutListService.queryPage(params);

        //字典表数据转换
        List<LiangcangChuruInoutListView> list =(List<LiangcangChuruInoutListView>)page.getList();
        for(LiangcangChuruInoutListView c:list){
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
        LiangcangChuruInoutListEntity liangcangChuruInoutList = liangcangChuruInoutListService.selectById(id);
        if(liangcangChuruInoutList !=null){
            //entity转view
            LiangcangChuruInoutListView view = new LiangcangChuruInoutListView();
            BeanUtils.copyProperties( liangcangChuruInoutList , view );//把实体数据重构到view中
            //级联表 出入库
            //级联表
            LiangcangChuruInoutEntity liangcangChuruInout = liangcangChuruInoutService.selectById(liangcangChuruInoutList.getLiangcangChuruInoutId());
            if(liangcangChuruInout != null){
            BeanUtils.copyProperties( liangcangChuruInout , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setLiangcangChuruInoutId(liangcangChuruInout.getId());
            }
            //级联表 粮仓
            //级联表
            LiangcangEntity liangcang = liangcangService.selectById(liangcangChuruInoutList.getLiangcangId());
            if(liangcang != null){
            BeanUtils.copyProperties( liangcang , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setLiangcangId(liangcang.getId());
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
    public R save(@RequestBody LiangcangChuruInoutListEntity liangcangChuruInoutList, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,liangcangChuruInoutList:{}",this.getClass().getName(),liangcangChuruInoutList.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<LiangcangChuruInoutListEntity> queryWrapper = new EntityWrapper<LiangcangChuruInoutListEntity>()
            .eq("liangcang_churu_inout_id", liangcangChuruInoutList.getLiangcangChuruInoutId())
            .eq("liangcang_id", liangcangChuruInoutList.getLiangcangId())
            .eq("liangcang_churu_inout_list_number", liangcangChuruInoutList.getLiangcangChuruInoutListNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LiangcangChuruInoutListEntity liangcangChuruInoutListEntity = liangcangChuruInoutListService.selectOne(queryWrapper);
        if(liangcangChuruInoutListEntity==null){
            liangcangChuruInoutList.setInsertTime(new Date());
            liangcangChuruInoutList.setCreateTime(new Date());
            liangcangChuruInoutListService.insert(liangcangChuruInoutList);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LiangcangChuruInoutListEntity liangcangChuruInoutList, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,liangcangChuruInoutList:{}",this.getClass().getName(),liangcangChuruInoutList.toString());
        LiangcangChuruInoutListEntity oldLiangcangChuruInoutListEntity = liangcangChuruInoutListService.selectById(liangcangChuruInoutList.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");

            liangcangChuruInoutListService.updateById(liangcangChuruInoutList);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<LiangcangChuruInoutListEntity> oldLiangcangChuruInoutListList =liangcangChuruInoutListService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        liangcangChuruInoutListService.deleteBatchIds(Arrays.asList(ids));

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
            List<LiangcangChuruInoutListEntity> liangcangChuruInoutListList = new ArrayList<>();//上传的东西
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
                            LiangcangChuruInoutListEntity liangcangChuruInoutListEntity = new LiangcangChuruInoutListEntity();
//                            liangcangChuruInoutListEntity.setLiangcangChuruInoutId(Integer.valueOf(data.get(0)));   //出入库 要改的
//                            liangcangChuruInoutListEntity.setLiangcangId(Integer.valueOf(data.get(0)));   //粮仓 要改的
//                            liangcangChuruInoutListEntity.setLiangcangChuruInoutListNumber(Integer.valueOf(data.get(0)));   //操作数量 要改的
//                            liangcangChuruInoutListEntity.setInsertTime(date);//时间
//                            liangcangChuruInoutListEntity.setCreateTime(date);//时间
                            liangcangChuruInoutListList.add(liangcangChuruInoutListEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        liangcangChuruInoutListService.insertBatch(liangcangChuruInoutListList);
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

