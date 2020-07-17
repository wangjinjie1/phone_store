package com.wjj.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

@Data
@AllArgsConstructor
public class PhoneCategoryVo {
    // 将 categoryName 转为 json 格式时 属性名变为需要的 name = ？
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
}
