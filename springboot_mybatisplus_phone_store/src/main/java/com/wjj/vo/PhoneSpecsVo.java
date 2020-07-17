package com.wjj.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PhoneSpecsVo {
    @JsonProperty("id")
    private Integer specsId;
    @JsonProperty("name")
    private String specsName;
    /**
     * 小图
     */
    @JsonProperty("imgUrl")
    private String specsIcon;
    /**
     * 预览图
     */
    @JsonProperty("previewImgUrl")
    private String specsPreview;
}
