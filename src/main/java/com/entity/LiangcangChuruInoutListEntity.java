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
 * 出入库详情
 *
 * @author 
 * @email
 */
@TableName("liangcang_churu_inout_list")
public class LiangcangChuruInoutListEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LiangcangChuruInoutListEntity() {

	}

	public LiangcangChuruInoutListEntity(T t) {
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
     * 出入库
     */
    @ColumnInfo(comment="出入库",type="int(11)")
    @TableField(value = "liangcang_churu_inout_id")

    private Integer liangcangChuruInoutId;


    /**
     * 粮仓
     */
    @ColumnInfo(comment="粮仓",type="int(11)")
    @TableField(value = "liangcang_id")

    private Integer liangcangId;


    /**
     * 操作数量
     */
    @ColumnInfo(comment="操作数量",type="int(11)")
    @TableField(value = "liangcang_churu_inout_list_number")

    private Integer liangcangChuruInoutListNumber;


    /**
     * 操作时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="操作时间",type="timestamp")
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
	 * 获取：出入库
	 */
    public Integer getLiangcangChuruInoutId() {
        return liangcangChuruInoutId;
    }
    /**
	 * 设置：出入库
	 */

    public void setLiangcangChuruInoutId(Integer liangcangChuruInoutId) {
        this.liangcangChuruInoutId = liangcangChuruInoutId;
    }
    /**
	 * 获取：粮仓
	 */
    public Integer getLiangcangId() {
        return liangcangId;
    }
    /**
	 * 设置：粮仓
	 */

    public void setLiangcangId(Integer liangcangId) {
        this.liangcangId = liangcangId;
    }
    /**
	 * 获取：操作数量
	 */
    public Integer getLiangcangChuruInoutListNumber() {
        return liangcangChuruInoutListNumber;
    }
    /**
	 * 设置：操作数量
	 */

    public void setLiangcangChuruInoutListNumber(Integer liangcangChuruInoutListNumber) {
        this.liangcangChuruInoutListNumber = liangcangChuruInoutListNumber;
    }
    /**
	 * 获取：操作时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：操作时间
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
        return "LiangcangChuruInoutList{" +
            ", id=" + id +
            ", liangcangChuruInoutId=" + liangcangChuruInoutId +
            ", liangcangId=" + liangcangId +
            ", liangcangChuruInoutListNumber=" + liangcangChuruInoutListNumber +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
