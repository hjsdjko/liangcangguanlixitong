package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.LiangcangChuruInoutEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 出入库
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("liangcang_churu_inout")
public class LiangcangChuruInoutView extends LiangcangChuruInoutEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 出入库类型的值
	*/
	@ColumnInfo(comment="出入库类型的字典表值",type="varchar(200)")
	private String liangcangChuruInoutValue;




	public LiangcangChuruInoutView() {

	}

	public LiangcangChuruInoutView(LiangcangChuruInoutEntity liangcangChuruInoutEntity) {
		try {
			BeanUtils.copyProperties(this, liangcangChuruInoutEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 出入库类型的值
	*/
	public String getLiangcangChuruInoutValue() {
		return liangcangChuruInoutValue;
	}
	/**
	* 设置： 出入库类型的值
	*/
	public void setLiangcangChuruInoutValue(String liangcangChuruInoutValue) {
		this.liangcangChuruInoutValue = liangcangChuruInoutValue;
	}




	@Override
	public String toString() {
		return "LiangcangChuruInoutView{" +
			", liangcangChuruInoutValue=" + liangcangChuruInoutValue +
			"} " + super.toString();
	}
}
