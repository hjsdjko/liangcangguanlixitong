package com.dao;

import com.entity.RenwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.RenwuView;

/**
 * 出受粮任务 Dao 接口
 *
 * @author 
 */
public interface RenwuDao extends BaseMapper<RenwuEntity> {

   List<RenwuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
