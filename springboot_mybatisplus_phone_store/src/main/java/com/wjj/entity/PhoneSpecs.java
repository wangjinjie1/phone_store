package com.wjj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * 商品规格表(PhoneSpecs)实体类
 *
 * @author makejava
 * @since 2020-07-12 21:10:38
 */
public class PhoneSpecs implements Serializable {
    private static final long serialVersionUID = -88926384293714576L;

    @TableId(type = IdType.AUTO)
    private Integer specsId;

    private String phoneId;
    /**
    * 规格名称
    */
    private String specsName;
    /**
    * 库存
    */
    private Integer specsStock;
    /**
    * 单价
    */
    private BigDecimal specsPrice;
    /**
    * 小图
    */
    private String specsIcon;
    /**
    * 预览图
    */
    private String specsPreview;
    /**
    * 修改时间
    */
    private Date updateTime;
    /**
    * 创建时间
    */
    private Date createTime;


    public Integer getSpecsId() {
        return specsId;
    }

    public void setSpecsId(Integer specsId) {
        this.specsId = specsId;
    }

    public String getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

    public String getSpecsName() {
        return specsName;
    }

    public void setSpecsName(String specsName) {
        this.specsName = specsName;
    }

    public Integer getSpecsStock() {
        return specsStock;
    }

    public void setSpecsStock(Integer specsStock) {
        this.specsStock = specsStock;
    }

    public BigDecimal getSpecsPrice() {
        return specsPrice;
    }

    public void setSpecsPrice(BigDecimal specsPrice) {
        this.specsPrice = specsPrice;
    }

    public String getSpecsIcon() {
        return specsIcon;
    }

    public void setSpecsIcon(String specsIcon) {
        this.specsIcon = specsIcon;
    }

    public String getSpecsPreview() {
        return specsPreview;
    }

    public void setSpecsPreview(String specsPreview) {
        this.specsPreview = specsPreview;
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
        return "PhoneSpecs{" +
                "specsId=" + specsId +
                ", phoneId='" + phoneId + '\'' +
                ", specsName='" + specsName + '\'' +
                ", specsStock=" + specsStock +
                ", specsPrice=" + specsPrice +
                ", specsIcon='" + specsIcon + '\'' +
                ", specsPreview='" + specsPreview + '\'' +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                '}';
    }
}
