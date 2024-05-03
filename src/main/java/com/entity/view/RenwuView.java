package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.RenwuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 出受粮任务
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("renwu")
public class RenwuView extends RenwuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 水稻种类的值
	*/
	@ColumnInfo(comment="水稻种类的字典表值",type="varchar(200)")
	private String renwuValue;
	/**
	* 出粮收粮的值
	*/
	@ColumnInfo(comment="出粮收粮的字典表值",type="varchar(200)")
	private String renwuShifouValue;

	//级联表 粮仓
					 
		/**
		* 粮仓 的 保管员
		*/
		@ColumnInfo(comment="保管员",type="int(11)")
		private Integer liangcangYonghuId;
		/**
		* 粮仓名称
		*/

		@ColumnInfo(comment="粮仓名称",type="varchar(200)")
		private String liangcangName;
		/**
		* 粮仓编号
		*/

		@ColumnInfo(comment="粮仓编号",type="varchar(200)")
		private String liangcangUuidNumber;
		/**
		* 粮仓照片
		*/

		@ColumnInfo(comment="粮仓照片",type="varchar(200)")
		private String liangcangPhoto;
		/**
		* 粮仓地点
		*/

		@ColumnInfo(comment="粮仓地点",type="varchar(200)")
		private String liangcangAddress;
		/**
		* 水稻种型
		*/
		@ColumnInfo(comment="水稻种型",type="int(11)")
		private Integer liangcangTypes;
			/**
			* 水稻种型的值
			*/
			@ColumnInfo(comment="水稻种型的字典表值",type="varchar(200)")
			private String liangcangValue;
		/**
		* 粮食最大容量
		*/

		@ColumnInfo(comment="粮食最大容量",type="int(11)")
		private Integer liangcangZuidaNumber;
		/**
		* 粮食现有量
		*/

		@ColumnInfo(comment="粮食现有量",type="int(11)")
		private Integer liangcangKucunNumber;
		/**
		* 当前温度
		*/
		@ColumnInfo(comment="当前温度",type="decimal(10,2)")
		private Double liangcangWendu;
		/**
		* 当前湿度
		*/
		@ColumnInfo(comment="当前湿度",type="decimal(10,2)")
		private Double liangcangShidu;
		/**
		* 含虫量
		*/

		@ColumnInfo(comment="含虫量",type="int(11)")
		private Integer liangcangHanchongliang;
		/**
		* 是否喷射农药
		*/
		@ColumnInfo(comment="是否喷射农药",type="int(11)")
		private Integer liangcangShifouTypes;
			/**
			* 是否喷射农药的值
			*/
			@ColumnInfo(comment="是否喷射农药的字典表值",type="varchar(200)")
			private String liangcangShifouValue;
		/**
		* 含杂率
		*/

		@ColumnInfo(comment="含杂率",type="int(11)")
		private Integer liangcangHanzalv;
		/**
		* 粮仓介绍
		*/

		@ColumnInfo(comment="粮仓介绍",type="longtext")
		private String liangcangContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer liangcangDelete;
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



	public RenwuView() {

	}

	public RenwuView(RenwuEntity renwuEntity) {
		try {
			BeanUtils.copyProperties(this, renwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 水稻种类的值
	*/
	public String getRenwuValue() {
		return renwuValue;
	}
	/**
	* 设置： 水稻种类的值
	*/
	public void setRenwuValue(String renwuValue) {
		this.renwuValue = renwuValue;
	}
	//当前表的
	/**
	* 获取： 出粮收粮的值
	*/
	public String getRenwuShifouValue() {
		return renwuShifouValue;
	}
	/**
	* 设置： 出粮收粮的值
	*/
	public void setRenwuShifouValue(String renwuShifouValue) {
		this.renwuShifouValue = renwuShifouValue;
	}


	//级联表的get和set 粮仓
		/**
		* 获取：粮仓 的 保管员
		*/
		public Integer getLiangcangYonghuId() {
			return liangcangYonghuId;
		}
		/**
		* 设置：粮仓 的 保管员
		*/
		public void setLiangcangYonghuId(Integer liangcangYonghuId) {
			this.liangcangYonghuId = liangcangYonghuId;
		}

		/**
		* 获取： 粮仓名称
		*/
		public String getLiangcangName() {
			return liangcangName;
		}
		/**
		* 设置： 粮仓名称
		*/
		public void setLiangcangName(String liangcangName) {
			this.liangcangName = liangcangName;
		}

		/**
		* 获取： 粮仓编号
		*/
		public String getLiangcangUuidNumber() {
			return liangcangUuidNumber;
		}
		/**
		* 设置： 粮仓编号
		*/
		public void setLiangcangUuidNumber(String liangcangUuidNumber) {
			this.liangcangUuidNumber = liangcangUuidNumber;
		}

		/**
		* 获取： 粮仓照片
		*/
		public String getLiangcangPhoto() {
			return liangcangPhoto;
		}
		/**
		* 设置： 粮仓照片
		*/
		public void setLiangcangPhoto(String liangcangPhoto) {
			this.liangcangPhoto = liangcangPhoto;
		}

		/**
		* 获取： 粮仓地点
		*/
		public String getLiangcangAddress() {
			return liangcangAddress;
		}
		/**
		* 设置： 粮仓地点
		*/
		public void setLiangcangAddress(String liangcangAddress) {
			this.liangcangAddress = liangcangAddress;
		}
		/**
		* 获取： 水稻种型
		*/
		public Integer getLiangcangTypes() {
			return liangcangTypes;
		}
		/**
		* 设置： 水稻种型
		*/
		public void setLiangcangTypes(Integer liangcangTypes) {
			this.liangcangTypes = liangcangTypes;
		}


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

		/**
		* 获取： 粮食最大容量
		*/
		public Integer getLiangcangZuidaNumber() {
			return liangcangZuidaNumber;
		}
		/**
		* 设置： 粮食最大容量
		*/
		public void setLiangcangZuidaNumber(Integer liangcangZuidaNumber) {
			this.liangcangZuidaNumber = liangcangZuidaNumber;
		}

		/**
		* 获取： 粮食现有量
		*/
		public Integer getLiangcangKucunNumber() {
			return liangcangKucunNumber;
		}
		/**
		* 设置： 粮食现有量
		*/
		public void setLiangcangKucunNumber(Integer liangcangKucunNumber) {
			this.liangcangKucunNumber = liangcangKucunNumber;
		}

		/**
		* 获取： 当前温度
		*/
		public Double getLiangcangWendu() {
			return liangcangWendu;
		}
		/**
		* 设置： 当前温度
		*/
		public void setLiangcangWendu(Double liangcangWendu) {
			this.liangcangWendu = liangcangWendu;
		}

		/**
		* 获取： 当前湿度
		*/
		public Double getLiangcangShidu() {
			return liangcangShidu;
		}
		/**
		* 设置： 当前湿度
		*/
		public void setLiangcangShidu(Double liangcangShidu) {
			this.liangcangShidu = liangcangShidu;
		}

		/**
		* 获取： 含虫量
		*/
		public Integer getLiangcangHanchongliang() {
			return liangcangHanchongliang;
		}
		/**
		* 设置： 含虫量
		*/
		public void setLiangcangHanchongliang(Integer liangcangHanchongliang) {
			this.liangcangHanchongliang = liangcangHanchongliang;
		}
		/**
		* 获取： 是否喷射农药
		*/
		public Integer getLiangcangShifouTypes() {
			return liangcangShifouTypes;
		}
		/**
		* 设置： 是否喷射农药
		*/
		public void setLiangcangShifouTypes(Integer liangcangShifouTypes) {
			this.liangcangShifouTypes = liangcangShifouTypes;
		}


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

		/**
		* 获取： 含杂率
		*/
		public Integer getLiangcangHanzalv() {
			return liangcangHanzalv;
		}
		/**
		* 设置： 含杂率
		*/
		public void setLiangcangHanzalv(Integer liangcangHanzalv) {
			this.liangcangHanzalv = liangcangHanzalv;
		}

		/**
		* 获取： 粮仓介绍
		*/
		public String getLiangcangContent() {
			return liangcangContent;
		}
		/**
		* 设置： 粮仓介绍
		*/
		public void setLiangcangContent(String liangcangContent) {
			this.liangcangContent = liangcangContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getLiangcangDelete() {
			return liangcangDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setLiangcangDelete(Integer liangcangDelete) {
			this.liangcangDelete = liangcangDelete;
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
		return "RenwuView{" +
			", renwuValue=" + renwuValue +
			", renwuShifouValue=" + renwuShifouValue +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", liangcangName=" + liangcangName +
			", liangcangUuidNumber=" + liangcangUuidNumber +
			", liangcangPhoto=" + liangcangPhoto +
			", liangcangAddress=" + liangcangAddress +
			", liangcangZuidaNumber=" + liangcangZuidaNumber +
			", liangcangKucunNumber=" + liangcangKucunNumber +
			", liangcangWendu=" + liangcangWendu +
			", liangcangShidu=" + liangcangShidu +
			", liangcangHanchongliang=" + liangcangHanchongliang +
			", liangcangHanzalv=" + liangcangHanzalv +
			", liangcangContent=" + liangcangContent +
			", liangcangDelete=" + liangcangDelete +
			"} " + super.toString();
	}
}
