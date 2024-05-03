package com.entity.vo;

import com.entity.LiangcangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 粮仓
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("liangcang")
public class LiangcangVO implements Serializable {
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
     * 粮仓名称
     */

    @TableField(value = "liangcang_name")
    private String liangcangName;


    /**
     * 粮仓编号
     */

    @TableField(value = "liangcang_uuid_number")
    private String liangcangUuidNumber;


    /**
     * 粮仓照片
     */

    @TableField(value = "liangcang_photo")
    private String liangcangPhoto;


    /**
     * 粮仓地点
     */

    @TableField(value = "liangcang_address")
    private String liangcangAddress;


    /**
     * 水稻种型
     */

    @TableField(value = "liangcang_types")
    private Integer liangcangTypes;


    /**
     * 粮食最大容量
     */

    @TableField(value = "liangcang_zuida_number")
    private Integer liangcangZuidaNumber;


    /**
     * 粮食现有量
     */

    @TableField(value = "liangcang_kucun_number")
    private Integer liangcangKucunNumber;


    /**
     * 当前温度
     */

    @TableField(value = "liangcang_wendu")
    private Double liangcangWendu;


    /**
     * 当前湿度
     */

    @TableField(value = "liangcang_shidu")
    private Double liangcangShidu;


    /**
     * 含虫量
     */

    @TableField(value = "liangcang_hanchongliang")
    private Integer liangcangHanchongliang;


    /**
     * 是否喷射农药
     */

    @TableField(value = "liangcang_shifou_types")
    private Integer liangcangShifouTypes;


    /**
     * 含杂率
     */

    @TableField(value = "liangcang_hanzalv")
    private Integer liangcangHanzalv;


    /**
     * 粮仓介绍
     */

    @TableField(value = "liangcang_content")
    private String liangcangContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "liangcang_delete")
    private Integer liangcangDelete;


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
	 * 设置：粮仓名称
	 */
    public String getLiangcangName() {
        return liangcangName;
    }


    /**
	 * 获取：粮仓名称
	 */

    public void setLiangcangName(String liangcangName) {
        this.liangcangName = liangcangName;
    }
    /**
	 * 设置：粮仓编号
	 */
    public String getLiangcangUuidNumber() {
        return liangcangUuidNumber;
    }


    /**
	 * 获取：粮仓编号
	 */

    public void setLiangcangUuidNumber(String liangcangUuidNumber) {
        this.liangcangUuidNumber = liangcangUuidNumber;
    }
    /**
	 * 设置：粮仓照片
	 */
    public String getLiangcangPhoto() {
        return liangcangPhoto;
    }


    /**
	 * 获取：粮仓照片
	 */

    public void setLiangcangPhoto(String liangcangPhoto) {
        this.liangcangPhoto = liangcangPhoto;
    }
    /**
	 * 设置：粮仓地点
	 */
    public String getLiangcangAddress() {
        return liangcangAddress;
    }


    /**
	 * 获取：粮仓地点
	 */

    public void setLiangcangAddress(String liangcangAddress) {
        this.liangcangAddress = liangcangAddress;
    }
    /**
	 * 设置：水稻种型
	 */
    public Integer getLiangcangTypes() {
        return liangcangTypes;
    }


    /**
	 * 获取：水稻种型
	 */

    public void setLiangcangTypes(Integer liangcangTypes) {
        this.liangcangTypes = liangcangTypes;
    }
    /**
	 * 设置：粮食最大容量
	 */
    public Integer getLiangcangZuidaNumber() {
        return liangcangZuidaNumber;
    }


    /**
	 * 获取：粮食最大容量
	 */

    public void setLiangcangZuidaNumber(Integer liangcangZuidaNumber) {
        this.liangcangZuidaNumber = liangcangZuidaNumber;
    }
    /**
	 * 设置：粮食现有量
	 */
    public Integer getLiangcangKucunNumber() {
        return liangcangKucunNumber;
    }


    /**
	 * 获取：粮食现有量
	 */

    public void setLiangcangKucunNumber(Integer liangcangKucunNumber) {
        this.liangcangKucunNumber = liangcangKucunNumber;
    }
    /**
	 * 设置：当前温度
	 */
    public Double getLiangcangWendu() {
        return liangcangWendu;
    }


    /**
	 * 获取：当前温度
	 */

    public void setLiangcangWendu(Double liangcangWendu) {
        this.liangcangWendu = liangcangWendu;
    }
    /**
	 * 设置：当前湿度
	 */
    public Double getLiangcangShidu() {
        return liangcangShidu;
    }


    /**
	 * 获取：当前湿度
	 */

    public void setLiangcangShidu(Double liangcangShidu) {
        this.liangcangShidu = liangcangShidu;
    }
    /**
	 * 设置：含虫量
	 */
    public Integer getLiangcangHanchongliang() {
        return liangcangHanchongliang;
    }


    /**
	 * 获取：含虫量
	 */

    public void setLiangcangHanchongliang(Integer liangcangHanchongliang) {
        this.liangcangHanchongliang = liangcangHanchongliang;
    }
    /**
	 * 设置：是否喷射农药
	 */
    public Integer getLiangcangShifouTypes() {
        return liangcangShifouTypes;
    }


    /**
	 * 获取：是否喷射农药
	 */

    public void setLiangcangShifouTypes(Integer liangcangShifouTypes) {
        this.liangcangShifouTypes = liangcangShifouTypes;
    }
    /**
	 * 设置：含杂率
	 */
    public Integer getLiangcangHanzalv() {
        return liangcangHanzalv;
    }


    /**
	 * 获取：含杂率
	 */

    public void setLiangcangHanzalv(Integer liangcangHanzalv) {
        this.liangcangHanzalv = liangcangHanzalv;
    }
    /**
	 * 设置：粮仓介绍
	 */
    public String getLiangcangContent() {
        return liangcangContent;
    }


    /**
	 * 获取：粮仓介绍
	 */

    public void setLiangcangContent(String liangcangContent) {
        this.liangcangContent = liangcangContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getLiangcangDelete() {
        return liangcangDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setLiangcangDelete(Integer liangcangDelete) {
        this.liangcangDelete = liangcangDelete;
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
