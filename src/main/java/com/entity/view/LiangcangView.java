package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.LiangcangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 粮仓
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("liangcang")
public class LiangcangView extends LiangcangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 水稻种型的值
	*/
	@ColumnInfo(comment="水稻种型的字典表值",type="varchar(200)")
	private String liangcangValue;
	/**
	* 是否喷射农药的值
	*/
	@ColumnInfo(comment="是否喷射农药的字典表值",type="varchar(200)")
	private String liangcangShifouValue;

	//级联表 粮仓保管员
		/**
		* 保管员姓名
		*/

		@ColumnInfo(comment="保管员姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 保管员手机号
		*/

		@ColumnInfo(comment="保管员手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 保管员身份证号
		*/

		@ColumnInfo(comment="保管员身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 保管员头像
		*/

		@ColumnInfo(comment="保管员头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 保管员邮箱
		*/

		@ColumnInfo(comment="保管员邮箱",type="varchar(200)")
		private String yonghuEmail;



	public LiangcangView() {

	}

	public LiangcangView(LiangcangEntity liangcangEntity) {
		try {
			BeanUtils.copyProperties(this, liangcangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 水稻种型的值
	*/
	public String getLiangcangValue() {
		return liangcangValue;
	}
	/**
	* 设置： 水稻种型的值
	*/
	public void setLiangcangValue(String liangcangValue) {
		this.liangcangValue = liangcangValue;
	}
	//当前表的
	/**
	* 获取： 是否喷射农药的值
	*/
	public String getLiangcangShifouValue() {
		return liangcangShifouValue;
	}
	/**
	* 设置： 是否喷射农药的值
	*/
	public void setLiangcangShifouValue(String liangcangShifouValue) {
		this.liangcangShifouValue = liangcangShifouValue;
	}


	//级联表的get和set 粮仓保管员

		/**
		* 获取： 保管员姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 保管员姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 保管员手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 保管员手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 保管员身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 保管员身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 保管员头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 保管员头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 保管员邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 保管员邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}


	@Override
	public String toString() {
		return "LiangcangView{" +
			", liangcangValue=" + liangcangValue +
			", liangcangShifouValue=" + liangcangShifouValue +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
