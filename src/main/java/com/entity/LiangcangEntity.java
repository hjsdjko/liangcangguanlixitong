package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 粮仓
 *
 * @author 
 * @email
 */
@TableName("liangcang")
public class LiangcangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LiangcangEntity() {

	}

	public LiangcangEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 保管员
     */
    @ColumnInfo(comment="保管员",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 粮仓名称
     */
    @ColumnInfo(comment="粮仓名称",type="varchar(200)")
    @TableField(value = "liangcang_name")

    private String liangcangName;


    /**
     * 粮仓编号
     */
    @ColumnInfo(comment="粮仓编号",type="varchar(200)")
    @TableField(value = "liangcang_uuid_number")

    private String liangcangUuidNumber;


    /**
     * 粮仓照片
     */
    @ColumnInfo(comment="粮仓照片",type="varchar(200)")
    @TableField(value = "liangcang_photo")

    private String liangcangPhoto;


    /**
     * 粮仓地点
     */
    @ColumnInfo(comment="粮仓地点",type="varchar(200)")
    @TableField(value = "liangcang_address")

    private String liangcangAddress;


    /**
     * 水稻种型
     */
    @ColumnInfo(comment="水稻种型",type="int(11)")
    @TableField(value = "liangcang_types")

    private Integer liangcangTypes;


    /**
     * 粮食最大容量
     */
    @ColumnInfo(comment="粮食最大容量",type="int(11)")
    @TableField(value = "liangcang_zuida_number")

    private Integer liangcangZuidaNumber;


    /**
     * 粮食现有量
     */
    @ColumnInfo(comment="粮食现有量",type="int(11)")
    @TableField(value = "liangcang_kucun_number")

    private Integer liangcangKucunNumber;


    /**
     * 当前温度
     */
    @ColumnInfo(comment="当前温度",type="decimal(10,2)")
    @TableField(value = "liangcang_wendu")

    private Double liangcangWendu;


    /**
     * 当前湿度
     */
    @ColumnInfo(comment="当前湿度",type="decimal(10,2)")
    @TableField(value = "liangcang_shidu")

    private Double liangcangShidu;


    /**
     * 含虫量
     */
    @ColumnInfo(comment="含虫量",type="int(11)")
    @TableField(value = "liangcang_hanchongliang")

    private Integer liangcangHanchongliang;


    /**
     * 是否喷射农药
     */
    @ColumnInfo(comment="是否喷射农药",type="int(11)")
    @TableField(value = "liangcang_shifou_types")

    private Integer liangcangShifouTypes;


    /**
     * 含杂率
     */
    @ColumnInfo(comment="含杂率",type="int(11)")
    @TableField(value = "liangcang_hanzalv")

    private Integer liangcangHanzalv;


    /**
     * 粮仓介绍
     */
    @ColumnInfo(comment="粮仓介绍",type="longtext")
    @TableField(value = "liangcang_content")

    private String liangcangContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "liangcang_delete")

    private Integer liangcangDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：保管员
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：保管员
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：粮仓名称
	 */
    public String getLiangcangName() {
        return liangcangName;
    }
    /**
	 * 设置：粮仓名称
	 */

    public void setLiangcangName(String liangcangName) {
        this.liangcangName = liangcangName;
    }
    /**
	 * 获取：粮仓编号
	 */
    public String getLiangcangUuidNumber() {
        return liangcangUuidNumber;
    }
    /**
	 * 设置：粮仓编号
	 */

    public void setLiangcangUuidNumber(String liangcangUuidNumber) {
        this.liangcangUuidNumber = liangcangUuidNumber;
    }
    /**
	 * 获取：粮仓照片
	 */
    public String getLiangcangPhoto() {
        return liangcangPhoto;
    }
    /**
	 * 设置：粮仓照片
	 */

    public void setLiangcangPhoto(String liangcangPhoto) {
        this.liangcangPhoto = liangcangPhoto;
    }
    /**
	 * 获取：粮仓地点
	 */
    public String getLiangcangAddress() {
        return liangcangAddress;
    }
    /**
	 * 设置：粮仓地点
	 */

    public void setLiangcangAddress(String liangcangAddress) {
        this.liangcangAddress = liangcangAddress;
    }
    /**
	 * 获取：水稻种型
	 */
    public Integer getLiangcangTypes() {
        return liangcangTypes;
    }
    /**
	 * 设置：水稻种型
	 */

    public void setLiangcangTypes(Integer liangcangTypes) {
        this.liangcangTypes = liangcangTypes;
    }
    /**
	 * 获取：粮食最大容量
	 */
    public Integer getLiangcangZuidaNumber() {
        return liangcangZuidaNumber;
    }
    /**
	 * 设置：粮食最大容量
	 */

    public void setLiangcangZuidaNumber(Integer liangcangZuidaNumber) {
        this.liangcangZuidaNumber = liangcangZuidaNumber;
    }
    /**
	 * 获取：粮食现有量
	 */
    public Integer getLiangcangKucunNumber() {
        return liangcangKucunNumber;
    }
    /**
	 * 设置：粮食现有量
	 */

    public void setLiangcangKucunNumber(Integer liangcangKucunNumber) {
        this.liangcangKucunNumber = liangcangKucunNumber;
    }
    /**
	 * 获取：当前温度
	 */
    public Double getLiangcangWendu() {
        return liangcangWendu;
    }
    /**
	 * 设置：当前温度
	 */

    public void setLiangcangWendu(Double liangcangWendu) {
        this.liangcangWendu = liangcangWendu;
    }
    /**
	 * 获取：当前湿度
	 */
    public Double getLiangcangShidu() {
        return liangcangShidu;
    }
    /**
	 * 设置：当前湿度
	 */

    public void setLiangcangShidu(Double liangcangShidu) {
        this.liangcangShidu = liangcangShidu;
    }
    /**
	 * 获取：含虫量
	 */
    public Integer getLiangcangHanchongliang() {
        return liangcangHanchongliang;
    }
    /**
	 * 设置：含虫量
	 */

    public void setLiangcangHanchongliang(Integer liangcangHanchongliang) {
        this.liangcangHanchongliang = liangcangHanchongliang;
    }
    /**
	 * 获取：是否喷射农药
	 */
    public Integer getLiangcangShifouTypes() {
        return liangcangShifouTypes;
    }
    /**
	 * 设置：是否喷射农药
	 */

    public void setLiangcangShifouTypes(Integer liangcangShifouTypes) {
        this.liangcangShifouTypes = liangcangShifouTypes;
    }
    /**
	 * 获取：含杂率
	 */
    public Integer getLiangcangHanzalv() {
        return liangcangHanzalv;
    }
    /**
	 * 设置：含杂率
	 */

    public void setLiangcangHanzalv(Integer liangcangHanzalv) {
        this.liangcangHanzalv = liangcangHanzalv;
    }
    /**
	 * 获取：粮仓介绍
	 */
    public String getLiangcangContent() {
        return liangcangContent;
    }
    /**
	 * 设置：粮仓介绍
	 */

    public void setLiangcangContent(String liangcangContent) {
        this.liangcangContent = liangcangContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getLiangcangDelete() {
        return liangcangDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setLiangcangDelete(Integer liangcangDelete) {
        this.liangcangDelete = liangcangDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Liangcang{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", liangcangName=" + liangcangName +
            ", liangcangUuidNumber=" + liangcangUuidNumber +
            ", liangcangPhoto=" + liangcangPhoto +
            ", liangcangAddress=" + liangcangAddress +
            ", liangcangTypes=" + liangcangTypes +
            ", liangcangZuidaNumber=" + liangcangZuidaNumber +
            ", liangcangKucunNumber=" + liangcangKucunNumber +
            ", liangcangWendu=" + liangcangWendu +
            ", liangcangShidu=" + liangcangShidu +
            ", liangcangHanchongliang=" + liangcangHanchongliang +
            ", liangcangShifouTypes=" + liangcangShifouTypes +
            ", liangcangHanzalv=" + liangcangHanzalv +
            ", liangcangContent=" + liangcangContent +
            ", liangcangDelete=" + liangcangDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
