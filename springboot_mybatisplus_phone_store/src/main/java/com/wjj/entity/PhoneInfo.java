package com.wjj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;
import java.io.Serializable;

/**
 * 商品表(PhoneInfo)实体类
 *
 * @author makejava
 * @since 2020-07-12 20:54:36
 */
public class PhoneInfo implements Serializable {
    private static final long serialVersionUID = 994228927534773538L;

    @TableId(type = IdType.AUTO)
    private Integer phoneId;
    /**
    * 商品名称
    */
    private String phoneName;
    /**
    * 商品单价
    */
    private Double phonePrice;
    /**
    * 描述
    */
    private String phoneDescription;
    /**
    * 库存
    */
    private Integer phoneStock;
    /**
    * 小图
    */
    private String phoneIcon;
    /**
    * 类目编号
    */
    private Integer categoryType;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date updateTime;
    /**
    * 标签
    */
    private String phoneTag;


    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public Double getPhonePrice() {
        return phonePrice;
    }

    public void setPhonePrice(Double phonePrice) {
        this.phonePrice = phonePrice;
    }

    public String getPhoneDescription() {
        return phoneDescription;
    }

    public void setPhoneDescription(String phoneDescription) {
        this.phoneDescription = phoneDescription;
    }

    public Integer getPhoneStock() {
        return phoneStock;
    }

    public void setPhoneStock(Integer phoneStock) {
        this.phoneStock = phoneStock;
    }

    public String getPhoneIcon() {
        return phoneIcon;
    }

    public void setPhoneIcon(String phoneIcon) {
        this.phoneIcon = phoneIcon;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPhoneTag() {
        return phoneTag;
    }

    public void setPhoneTag(String phoneTag) {
        this.phoneTag = phoneTag;
    }

    @Override
    public String toString() {
        return "PhoneInfo{" +
                "phoneId=" + phoneId +
                ", phoneName='" + phoneName + '\'' +
                ", phonePrice=" + phonePrice +
                ", phoneDescription='" + phoneDescription + '\'' +
                ", phoneStock=" + phoneStock +
                ", phoneIcon='" + phoneIcon + '\'' +
                ", categoryType=" + categoryType +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", phoneTag='" + phoneTag + '\'' +
                '}';
    }
}
