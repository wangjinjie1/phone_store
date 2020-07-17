package com.wjj.service;

import com.wjj.vo.DataVo;
import com.wjj.vo.PhoneInfoVo;
import com.wjj.vo.SpecsPackageVo;

import java.util.List;

public interface PhoneService {
    public DataVo findDateVo();
    public List<PhoneInfoVo> findPhoneInfoVoByCategoryType(Integer categoryType);
    public SpecsPackageVo findSpecsByPhoneId(Integer phoneId);
    public void subStock(Integer specsId,Integer quantity);
}
