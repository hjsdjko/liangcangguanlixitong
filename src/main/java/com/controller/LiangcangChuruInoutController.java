
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
 * 出入库
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/liangcangChuruInout")
public class LiangcangChuruInoutController {
    private static final Logger logger = LoggerFactory.getLogger(LiangcangChuruInoutController.class);

    private static final String TABLE_NAME = "liangcangChuruInout";

    @Autowired
    private LiangcangChuruInoutService liangcangChuruInoutService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private LiangcangService liangcangService;//粮仓
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
        CommonUtil.checkMap(params);
        PageUtils page = liangcangChuruInoutService.queryPage(params);

        //字典表数据转换
        List<LiangcangChuruInoutView> list =(List<LiangcangChuruInoutView>)page.getList();
        for(LiangcangChuruInoutView c:list){
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
        LiangcangChuruInoutEntity liangcangChuruInout = liangcangChuruInoutService.selectById(id);
        if(liangcangChuruInout !=null){
            //entity转view
            LiangcangChuruInoutView view = new LiangcangChuruInoutView();
            BeanUtils.copyProperties( liangcangChuruInout , view );//把实体数据重构到view中
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
    public R save(@RequestBody LiangcangChuruInoutEntity liangcangChuruInout, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,liangcangChuruInout:{}",this.getClass().getName(),liangcangChuruInout.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<LiangcangChuruInoutEntity> queryWrapper = new EntityWrapper<LiangcangChuruInoutEntity>()
            .eq("liangcang_churu_inout_name", liangcangChuruInout.getLiangcangChuruInoutName())
            .eq("liangcang_churu_inout_types", liangcangChuruInout.getLiangcangChuruInoutTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LiangcangChuruInoutEntity liangcangChuruInoutEntity = liangcangChuruInoutService.selectOne(queryWrapper);
        if(liangcangChuruInoutEntity==null){
            liangcangChuruInout.setInsertTime(new Date());
            liangcangChuruInout.setCreateTime(new Date());
            liangcangChuruInoutService.insert(liangcangChuruInout);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LiangcangChuruInoutEntity liangcangChuruInout, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,liangcangChuruInout:{}",this.getClass().getName(),liangcangChuruInout.toString());
        LiangcangChuruInoutEntity oldLiangcangChuruInoutEntity = liangcangChuruInoutService.selectById(liangcangChuruInout.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");

            liangcangChuruInoutService.updateById(liangcangChuruInout);//根据id更新
            return R.ok();
    }


    /**
    * 出库
    */
    @RequestMapping("/outLiangcangChuruInoutList")
    public R outLiangcangChuruInoutList(@RequestBody  Map<String, Object> params,HttpServletRequest request){
        logger.debug("outLiangcangChuruInoutList方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        String role = String.valueOf(request.getSession().getAttribute("role"));

        //取出入库名称并判断是否存在
        String liangcangChuruInoutName = String.valueOf(params.get("liangcangChuruInoutName"));
        Wrapper<LiangcangChuruInoutEntity> queryWrapper = new EntityWrapper<LiangcangChuruInoutEntity>()
            .eq("liangcang_churu_inout_name", liangcangChuruInoutName)
            ;
        LiangcangChuruInoutEntity liangcangChuruInoutSelectOne = liangcangChuruInoutService.selectOne(queryWrapper);
        if(liangcangChuruInoutSelectOne != null)
            return R.error(511,"出入库名称已被使用");



        Map<String, Integer> map = (Map<String, Integer>) params.get("map");
        if(map == null || map.size() == 0)
            return R.error(511,"列表内容不能为空");


        Set<String> ids = map.keySet();

        List<LiangcangEntity> liangcangList = liangcangService.selectBatchIds(ids);
        if(liangcangList == null || liangcangList.size() == 0){
            return R.error(511,"查数据库查不到数据");
        }else{
            for(LiangcangEntity w:liangcangList){
                Integer value = w.getLiangcangKucunNumber()-map.get(String.valueOf(w.getId()));
                if(value <0){
                    return R.error(511,"出库数量大于库存数量");
                }
                w.setLiangcangKucunNumber(value);
            }
        }

        //当前表
        LiangcangChuruInoutEntity liangcangChuruInoutEntity = new LiangcangChuruInoutEntity<>();
            liangcangChuruInoutEntity.setLiangcangChuruInoutUuidNumber(String.valueOf(new Date().getTime()));
            liangcangChuruInoutEntity.setLiangcangChuruInoutName(liangcangChuruInoutName);
            liangcangChuruInoutEntity.setLiangcangChuruInoutTypes(1);
            liangcangChuruInoutEntity.setLiangcangChuruInoutContent("");
            liangcangChuruInoutEntity.setInsertTime(new Date());
            liangcangChuruInoutEntity.setCreateTime(new Date());

        boolean insertLiangcangChuruInout = liangcangChuruInoutService.insert(liangcangChuruInoutEntity);
        //list表
        ArrayList<LiangcangChuruInoutListEntity> liangcangChuruInoutLists = new ArrayList<>();
        if(insertLiangcangChuruInout){
            for(String id:ids){
                LiangcangChuruInoutListEntity liangcangChuruInoutListEntity = new LiangcangChuruInoutListEntity();
                    liangcangChuruInoutListEntity.setLiangcangChuruInoutId(liangcangChuruInoutEntity.getId());
                    liangcangChuruInoutListEntity.setLiangcangId(Integer.valueOf(id));
                    liangcangChuruInoutListEntity.setLiangcangChuruInoutListNumber(map.get(id));
                    liangcangChuruInoutListEntity.setInsertTime(new Date());
                    liangcangChuruInoutListEntity.setCreateTime(new Date());
                liangcangChuruInoutLists.add(liangcangChuruInoutListEntity);
                liangcangService.updateBatchById(liangcangList);
            }
            liangcangChuruInoutListService.insertBatch(liangcangChuruInoutLists);
        }

        return R.ok();
    }

    /**
    *入库
    */
    @RequestMapping("/inLiangcangChuruInoutList")
    public R inLiangcangChuruInoutList(@RequestBody  Map<String, Object> params,HttpServletRequest request){
        logger.debug("inLiangcangChuruInoutList方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        //params:{"map":{"1":2,"2":3},"wuziOutinName":"订单1"}

        String role = String.valueOf(request.getSession().getAttribute("role"));

        //取当前表名称并判断
        String liangcangChuruInoutName = String.valueOf(params.get("liangcangChuruInoutName"));
        Wrapper<LiangcangChuruInoutEntity> queryWrapper = new EntityWrapper<LiangcangChuruInoutEntity>()
            .eq("liangcang_churu_inout_name", liangcangChuruInoutName)
            ;
        LiangcangChuruInoutEntity liangcangChuruInoutSelectOne = liangcangChuruInoutService.selectOne(queryWrapper);
        if(liangcangChuruInoutSelectOne != null)
            return R.error(511,"出入库名称已被使用");


        Map<String, Integer> map = (Map<String, Integer>) params.get("map");
        if(map == null || map.size() == 0)
            return R.error(511,"列表内容不能为空");

        Set<String> ids = map.keySet();

        List<LiangcangEntity> liangcangList = liangcangService.selectBatchIds(ids);
        if(liangcangList == null || liangcangList.size() == 0){
            return R.error(511,"查数据库查不到数据");
        }else{
            for(LiangcangEntity w:liangcangList){
                w.setLiangcangKucunNumber(w.getLiangcangKucunNumber()+map.get(String.valueOf(w.getId())));
            }
        }

        //当前表
        LiangcangChuruInoutEntity liangcangChuruInoutEntity = new LiangcangChuruInoutEntity<>();
            liangcangChuruInoutEntity.setLiangcangChuruInoutUuidNumber(String.valueOf(new Date().getTime()));
            liangcangChuruInoutEntity.setLiangcangChuruInoutName(liangcangChuruInoutName);
            liangcangChuruInoutEntity.setLiangcangChuruInoutTypes(2);
            liangcangChuruInoutEntity.setLiangcangChuruInoutContent("");
            liangcangChuruInoutEntity.setInsertTime(new Date());
            liangcangChuruInoutEntity.setCreateTime(new Date());


        boolean insertLiangcangChuruInout = liangcangChuruInoutService.insert(liangcangChuruInoutEntity);
        //list表
        ArrayList<LiangcangChuruInoutListEntity> liangcangChuruInoutLists = new ArrayList<>();
        if(insertLiangcangChuruInout){
            for(String id:ids){
                LiangcangChuruInoutListEntity liangcangChuruInoutListEntity = new LiangcangChuruInoutListEntity();
                liangcangChuruInoutListEntity.setLiangcangChuruInoutId(liangcangChuruInoutEntity.getId());
                liangcangChuruInoutListEntity.setLiangcangId(Integer.valueOf(id));
                liangcangChuruInoutListEntity.setLiangcangChuruInoutListNumber(map.get(id));
                liangcangChuruInoutListEntity.setInsertTime(new Date());
                liangcangChuruInoutListEntity.setCreateTime(new Date());
                liangcangChuruInoutLists.add(liangcangChuruInoutListEntity);
                liangcangService.updateBatchById(liangcangList);
            }
            liangcangChuruInoutListService.insertBatch(liangcangChuruInoutLists);
        }

        return R.ok();
    }
    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<LiangcangChuruInoutEntity> oldLiangcangChuruInoutList =liangcangChuruInoutService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        liangcangChuruInoutService.deleteBatchIds(Arrays.asList(ids));
        liangcangChuruInoutListService.delete(new EntityWrapper<LiangcangChuruInoutListEntity>().in("liangcang_churu_inout_id",ids));

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
            List<LiangcangChuruInoutEntity> liangcangChuruInoutList = new ArrayList<>();//上传的东西
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
                            LiangcangChuruInoutEntity liangcangChuruInoutEntity = new LiangcangChuruInoutEntity();
//                            liangcangChuruInoutEntity.setLiangcangChuruInoutUuidNumber(data.get(0));                    //出入库流水号 要改的
//                            liangcangChuruInoutEntity.setLiangcangChuruInoutName(data.get(0));                    //出入库名称 要改的
//                            liangcangChuruInoutEntity.setLiangcangChuruInoutTypes(Integer.valueOf(data.get(0)));   //出入库类型 要改的
//                            liangcangChuruInoutEntity.setLiangcangChuruInoutContent("");//详情和图片
//                            liangcangChuruInoutEntity.setInsertTime(date);//时间
//                            liangcangChuruInoutEntity.setCreateTime(date);//时间
                            liangcangChuruInoutList.add(liangcangChuruInoutEntity);


                            //把要查询是否重复的字段放入map中
                                //出入库流水号
                                if(seachFields.containsKey("liangcangChuruInoutUuidNumber")){
                                    List<String> liangcangChuruInoutUuidNumber = seachFields.get("liangcangChuruInoutUuidNumber");
                                    liangcangChuruInoutUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> liangcangChuruInoutUuidNumber = new ArrayList<>();
                                    liangcangChuruInoutUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("liangcangChuruInoutUuidNumber",liangcangChuruInoutUuidNumber);
                                }
                        }

                        //查询是否重复
                         //出入库流水号
                        List<LiangcangChuruInoutEntity> liangcangChuruInoutEntities_liangcangChuruInoutUuidNumber = liangcangChuruInoutService.selectList(new EntityWrapper<LiangcangChuruInoutEntity>().in("liangcang_churu_inout_uuid_number", seachFields.get("liangcangChuruInoutUuidNumber")));
                        if(liangcangChuruInoutEntities_liangcangChuruInoutUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(LiangcangChuruInoutEntity s:liangcangChuruInoutEntities_liangcangChuruInoutUuidNumber){
                                repeatFields.add(s.getLiangcangChuruInoutUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [出入库流水号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        liangcangChuruInoutService.insertBatch(liangcangChuruInoutList);
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

