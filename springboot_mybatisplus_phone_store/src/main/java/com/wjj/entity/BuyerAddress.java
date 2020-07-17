package com.wjj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;
import java.io.Serializable;

/**
 * 收货地址表(BuyerAddress)实体类
 *
 * @author makejava
 * @since 2020-07-12 21:23:41
 */
public class BuyerAddress implements Serializable {
    private static final long serialVersionUID = -49270948687986176L;

    @TableId(type = IdType.AUTO)
    private Integer addressId;
    /**
    * 买家名字
    */
    private String buyerName;
    /**
    * 买家电话
    */
    private String buyerPhone;
    /**
    * 买家地址
    */
    private String buyerAddress;
    /**
    * 地址编码
    */
    private String areaCode;
    /**
    * 修改时间
    */
    private Date updateTime;
    /**
    * 创建时间
    */
    private Date createTime;


    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BuyerAddress{" +
                "addressId=" + addressId +
                ", buyerName='" + buyerName + '\'' +
                ", buyerPhone='" + buyerPhone + '\'' +
                ", buyerAddress='" + buyerAddress + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                '}';
    }
}
