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
 * 出受粮任务
 *
 * @author 
 * @email
 */
@TableName("renwu")
public class RenwuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public RenwuEntity() {

	}

	public RenwuEntity(T t) {
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
     * 粮仓
     */
    @ColumnInfo(comment="粮仓",type="int(11)")
    @TableField(value = "liangcang_id")

    private Integer liangcangId;


    /**
     * 水稻种类
     */
    @ColumnInfo(comment="水稻种类",type="int(11)")
    @TableField(value = "renwu_types")

    private Integer renwuTypes;


    /**
     * 出受量
     */
    @ColumnInfo(comment="出受量",type="int(11)")
    @TableField(value = "renwu_xianyou_number")

    private Integer renwuXianyouNumber;


    /**
     * 出粮收粮
     */
    @ColumnInfo(comment="出粮收粮",type="int(11)")
    @TableField(value = "renwu_shifou_types")

    private Integer renwuShifouTypes;


    /**
     * 价格
     */
    @ColumnInfo(comment="价格",type="decimal(10,2)")
    @TableField(value = "renwu_new_money")

    private Double renwuNewMoney;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "renwu_delete")

    private Integer renwuDelete;


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
	 * 获取：水稻种类
	 */
    public Integer getRenwuTypes() {
        return renwuTypes;
    }
    /**
	 * 设置：水稻种类
	 */

    public void setRenwuTypes(Integer renwuTypes) {
        this.renwuTypes = renwuTypes;
    }
    /**
	 * 获取：出受量
	 */
    public Integer getRenwuXianyouNumber() {
        return renwuXianyouNumber;
    }
    /**
	 * 设置：出受量
	 */

    public void setRenwuXianyouNumber(Integer renwuXianyouNumber) {
        this.renwuXianyouNumber = renwuXianyouNumber;
    }
    /**
	 * 获取：出粮收粮
	 */
    public Integer getRenwuShifouTypes() {
        return renwuShifouTypes;
    }
    /**
	 * 设置：出粮收粮
	 */

    public void setRenwuShifouTypes(Integer renwuShifouTypes) {
        this.renwuShifouTypes = renwuShifouTypes;
    }
    /**
	 * 获取：价格
	 */
    public Double getRenwuNewMoney() {
        return renwuNewMoney;
    }
    /**
	 * 设置：价格
	 */

    public void setRenwuNewMoney(Double renwuNewMoney) {
        this.renwuNewMoney = renwuNewMoney;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getRenwuDelete() {
        return renwuDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setRenwuDelete(Integer renwuDelete) {
        this.renwuDelete = renwuDelete;
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
        return "Renwu{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", liangcangId=" + liangcangId +
            ", renwuTypes=" + renwuTypes +
            ", renwuXianyouNumber=" + renwuXianyouNumber +
            ", renwuShifouTypes=" + renwuShifouTypes +
            ", renwuNewMoney=" + renwuNewMoney +
            ", renwuDelete=" + renwuDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
