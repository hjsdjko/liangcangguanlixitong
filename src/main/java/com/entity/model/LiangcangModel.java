package com.entity.model;

import com.entity.LiangcangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 粮仓
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LiangcangModel implements Serializable {
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
     * 粮仓名称
     */
    private String liangcangName;


    /**
     * 粮仓编号
     */
    private String liangcangUuidNumber;


    /**
     * 粮仓照片
     */
    private String liangcangPhoto;


    /**
     * 粮仓地点
     */
    private String liangcangAddress;


    /**
     * 水稻种型
     */
    private Integer liangcangTypes;


    /**
     * 粮食最大容量
     */
    private Integer liangcangZuidaNumber;


    /**
     * 粮食现有量
     */
    private Integer liangcangKucunNumber;


    /**
     * 当前温度
     */
    private Double liangcangWendu;


    /**
     * 当前湿度
     */
    private Double liangcangShidu;


    /**
     * 含虫量
     */
    private Integer liangcangHanchongliang;


    /**
     * 是否喷射农药
     */
    private Integer liangcangShifouTypes;


    /**
     * 含杂率
     */
    private Integer liangcangHanzalv;


    /**
     * 粮仓介绍
     */
    private String liangcangContent;


    /**
     * 逻辑删除
     */
    private Integer liangcangDelete;


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
