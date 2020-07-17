package com.wjj.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PhoneSpecsCasVo {
    @JsonProperty("s1")
    private Integer specsId;
    @JsonProperty("price")
    private BigDecimal specsPrice;
    /**
     * 库存
     */
    @JsonProperty("stock_num")
    private Integer specsStock;
}
