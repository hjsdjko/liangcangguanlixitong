package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.LiangcangChuruInoutListEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 出入库详情
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("liangcang_churu_inout_list")
public class LiangcangChuruInoutListView extends LiangcangChuruInoutListEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

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
	//级联表 出入库
		/**
		* 出入库流水号
		*/

		@ColumnInfo(comment="出入库流水号",type="varchar(200)")
		private String liangcangChuruInoutUuidNumber;
		/**
		* 出入库名称
		*/

		@ColumnInfo(comment="出入库名称",type="varchar(200)")
		private String liangcangChuruInoutName;
		/**
		* 出入库类型
		*/
		@ColumnInfo(comment="出入库类型",type="int(11)")
		private Integer liangcangChuruInoutTypes;
			/**
			* 出入库类型的值
			*/
			@ColumnInfo(comment="出入库类型的字典表值",type="varchar(200)")
			private String liangcangChuruInoutValue;
		/**
		* 备注
		*/

		@ColumnInfo(comment="备注",type="longtext")
		private String liangcangChuruInoutContent;



	public LiangcangChuruInoutListView() {

	}

	public LiangcangChuruInoutListView(LiangcangChuruInoutListEntity liangcangChuruInoutListEntity) {
		try {
			BeanUtils.copyProperties(this, liangcangChuruInoutListEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	//级联表的get和set 出入库

		/**
		* 获取： 出入库流水号
		*/
		public String getLiangcangChuruInoutUuidNumber() {
			return liangcangChuruInoutUuidNumber;
		}
		/**
		* 设置： 出入库流水号
		*/
		public void setLiangcangChuruInoutUuidNumber(String liangcangChuruInoutUuidNumber) {
			this.liangcangChuruInoutUuidNumber = liangcangChuruInoutUuidNumber;
		}

		/**
		* 获取： 出入库名称
		*/
		public String getLiangcangChuruInoutName() {
			return liangcangChuruInoutName;
		}
		/**
		* 设置： 出入库名称
		*/
		public void setLiangcangChuruInoutName(String liangcangChuruInoutName) {
			this.liangcangChuruInoutName = liangcangChuruInoutName;
		}
		/**
		* 获取： 出入库类型
		*/
		public Integer getLiangcangChuruInoutTypes() {
			return liangcangChuruInoutTypes;
		}
		/**
		* 设置： 出入库类型
		*/
		public void setLiangcangChuruInoutTypes(Integer liangcangChuruInoutTypes) {
			this.liangcangChuruInoutTypes = liangcangChuruInoutTypes;
		}


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

		/**
		* 获取： 备注
		*/
		public String getLiangcangChuruInoutContent() {
			return liangcangChuruInoutContent;
		}
		/**
		* 设置： 备注
		*/
		public void setLiangcangChuruInoutContent(String liangcangChuruInoutContent) {
			this.liangcangChuruInoutContent = liangcangChuruInoutContent;
		}


	@Override
	public String toString() {
		return "LiangcangChuruInoutListView{" +
			", liangcangChuruInoutUuidNumber=" + liangcangChuruInoutUuidNumber +
			", liangcangChuruInoutName=" + liangcangChuruInoutName +
			", liangcangChuruInoutContent=" + liangcangChuruInoutContent +
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
