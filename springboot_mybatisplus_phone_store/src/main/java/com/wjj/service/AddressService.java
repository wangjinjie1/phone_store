package com.wjj.service;

import com.wjj.form.AddressForm;
import com.wjj.vo.AddressVo;

import java.util.List;

public interface AddressService {
    public List<AddressVo> findAll();
    public void saveOrUpdate(AddressForm addressForm);
}
