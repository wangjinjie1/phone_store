package com.wjj.vo;

import lombok.Data;

import java.util.Map;

@Data
public class SpecsPackageVo {
    private Map<String, String> goods;
    private SkuVo sku;
}
