package com.wjj.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class PhoneInfoVo {
    @JsonProperty("id")
    private Integer phoneId;
    /**
     * 商品名称
     */
    @JsonProperty("title")
    private String phoneName;
    /**
     * 商品单价
     */
    @JsonProperty("price")
    private Double phonePrice;
    /**
     * 描述
     */
    @JsonProperty("desc")
    private String phoneDescription;

    /**
     * 小图
     */
    @JsonProperty("thumb")
    private String phoneIcon;
    /**
     * 标签
     */
    private List<Map<String, String>> tag;
}
