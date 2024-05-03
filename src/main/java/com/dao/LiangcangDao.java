package com.dao;

import com.entity.LiangcangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LiangcangView;

/**
 * 粮仓 Dao 接口
 *
 * @author 
 */
public interface LiangcangDao extends BaseMapper<LiangcangEntity> {

   List<LiangcangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
