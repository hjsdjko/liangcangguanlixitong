package com.entity.vo;

import com.entity.RenwuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 出受粮任务
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("renwu")
public class RenwuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 保管员
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 粮仓
     */

    @TableField(value = "liangcang_id")
    private Integer liangcangId;


    /**
     * 水稻种类
     */

    @TableField(value = "renwu_types")
    private Integer renwuTypes;


    /**
     * 出受量
     */

    @TableField(value = "renwu_xianyou_number")
    private Integer renwuXianyouNumber;


    /**
     * 出粮收粮
     */

    @TableField(value = "renwu_shifou_types")
    private Integer renwuShifouTypes;


    /**
     * 价格
     */

    @TableField(value = "renwu_new_money")
    private Double renwuNewMoney;


    /**
     * 逻辑删除
     */

    @TableField(value = "renwu_delete")
    private Integer renwuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：保管员
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：保管员
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：粮仓
	 */
    public Integer getLiangcangId() {
        return liangcangId;
    }


    /**
	 * 获取：粮仓
	 */

    public void setLiangcangId(Integer liangcangId) {
        this.liangcangId = liangcangId;
    }
    /**
	 * 设置：水稻种类
	 */
    public Integer getRenwuTypes() {
        return renwuTypes;
    }


    /**
	 * 获取：水稻种类
	 */

    public void setRenwuTypes(Integer renwuTypes) {
        this.renwuTypes = renwuTypes;
    }
    /**
	 * 设置：出受量
	 */
    public Integer getRenwuXianyouNumber() {
        return renwuXianyouNumber;
    }


    /**
	 * 获取：出受量
	 */

    public void setRenwuXianyouNumber(Integer renwuXianyouNumber) {
        this.renwuXianyouNumber = renwuXianyouNumber;
    }
    /**
	 * 设置：出粮收粮
	 */
    public Integer getRenwuShifouTypes() {
        return renwuShifouTypes;
    }


    /**
	 * 获取：出粮收粮
	 */

    public void setRenwuShifouTypes(Integer renwuShifouTypes) {
        this.renwuShifouTypes = renwuShifouTypes;
    }
    /**
	 * 设置：价格
	 */
    public Double getRenwuNewMoney() {
        return renwuNewMoney;
    }


    /**
	 * 获取：价格
	 */

    public void setRenwuNewMoney(Double renwuNewMoney) {
        this.renwuNewMoney = renwuNewMoney;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getRenwuDelete() {
        return renwuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setRenwuDelete(Integer renwuDelete) {
        this.renwuDelete = renwuDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
