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
 * 出入库
 *
 * @author 
 * @email
 */
@TableName("liangcang_churu_inout")
public class LiangcangChuruInoutEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LiangcangChuruInoutEntity() {

	}

	public LiangcangChuruInoutEntity(T t) {
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
     * 出入库流水号
     */
    @ColumnInfo(comment="出入库流水号",type="varchar(200)")
    @TableField(value = "liangcang_churu_inout_uuid_number")

    private String liangcangChuruInoutUuidNumber;


    /**
     * 出入库名称
     */
    @ColumnInfo(comment="出入库名称",type="varchar(200)")
    @TableField(value = "liangcang_churu_inout_name")

    private String liangcangChuruInoutName;


    /**
     * 出入库类型
     */
    @ColumnInfo(comment="出入库类型",type="int(11)")
    @TableField(value = "liangcang_churu_inout_types")

    private Integer liangcangChuruInoutTypes;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="longtext")
    @TableField(value = "liangcang_churu_inout_content")

    private String liangcangChuruInoutContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="添加时间",type="timestamp")
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
	 * 获取：出入库流水号
	 */
    public String getLiangcangChuruInoutUuidNumber() {
        return liangcangChuruInoutUuidNumber;
    }
    /**
	 * 设置：出入库流水号
	 */

    public void setLiangcangChuruInoutUuidNumber(String liangcangChuruInoutUuidNumber) {
        this.liangcangChuruInoutUuidNumber = liangcangChuruInoutUuidNumber;
    }
    /**
	 * 获取：出入库名称
	 */
    public String getLiangcangChuruInoutName() {
        return liangcangChuruInoutName;
    }
    /**
	 * 设置：出入库名称
	 */

    public void setLiangcangChuruInoutName(String liangcangChuruInoutName) {
        this.liangcangChuruInoutName = liangcangChuruInoutName;
    }
    /**
	 * 获取：出入库类型
	 */
    public Integer getLiangcangChuruInoutTypes() {
        return liangcangChuruInoutTypes;
    }
    /**
	 * 设置：出入库类型
	 */

    public void setLiangcangChuruInoutTypes(Integer liangcangChuruInoutTypes) {
        this.liangcangChuruInoutTypes = liangcangChuruInoutTypes;
    }
    /**
	 * 获取：备注
	 */
    public String getLiangcangChuruInoutContent() {
        return liangcangChuruInoutContent;
    }
    /**
	 * 设置：备注
	 */

    public void setLiangcangChuruInoutContent(String liangcangChuruInoutContent) {
        this.liangcangChuruInoutContent = liangcangChuruInoutContent;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：添加时间
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
        return "LiangcangChuruInout{" +
            ", id=" + id +
            ", liangcangChuruInoutUuidNumber=" + liangcangChuruInoutUuidNumber +
            ", liangcangChuruInoutName=" + liangcangChuruInoutName +
            ", liangcangChuruInoutTypes=" + liangcangChuruInoutTypes +
            ", liangcangChuruInoutContent=" + liangcangChuruInoutContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
