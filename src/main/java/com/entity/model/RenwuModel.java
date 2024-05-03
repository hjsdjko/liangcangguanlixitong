package com.entity.model;

import com.entity.RenwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 出受粮任务
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class RenwuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 保管员
     */
    private Integer yonghuId;


    /**
     * 粮仓
     */
    private Integer liangcangId;


    /**
     * 水稻种类
     */
    private Integer renwuTypes;


    /**
     * 出受量
     */
    private Integer renwuXianyouNumber;


    /**
     * 出粮收粮
     */
    private Integer renwuShifouTypes;


    /**
     * 价格
     */
    private Double renwuNewMoney;


    /**
     * 逻辑删除
     */
    private Integer renwuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
