package com.wjj.service.impl;

import com.wjj.form.AddressForm;
import com.wjj.service.AddressService;
import com.wjj.vo.AddressVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressServiceImplTest {


    @Autowired
    private AddressService addressService;
    @Test
    void findAll() {
        List<AddressVo> addressVoList = addressService.findAll();
        int id = 0;
    }

    @Test
    void saveOrUpdate(){

        AddressForm addressForm = new AddressForm();
        addressForm.setId(45);
        addressForm.setName("xiao123");
        addressForm.setTel("13655559999");
        addressForm.setProvince("北京市");
        addressForm.setCity("北京市");
        addressForm.setCounty("东城区");
        addressForm.setAreaCode("110101");
        addressForm.setAddressDetail("168号");

        addressService.saveOrUpdate(addressForm);
    }
}
