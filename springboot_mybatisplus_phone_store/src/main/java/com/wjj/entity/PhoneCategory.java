package com.wjj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 类目表(PhoneCategory)实体类
 *
 * @author makejava
 * @since 2020-07-12 19:49:09
 */
public class PhoneCategory implements Serializable {
    private static final long serialVersionUID = 528082956619282523L;

    @TableId(type = IdType.AUTO)
    private Integer categoryId;
    /**
    * 类目名称
    */
    private String categoryName;
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


    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    @Override
    public String toString() {
        return "PhoneCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryType=" + categoryType +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
