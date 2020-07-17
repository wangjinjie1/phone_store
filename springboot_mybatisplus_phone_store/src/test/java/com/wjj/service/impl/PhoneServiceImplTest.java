package com.wjj.service.impl;

import com.wjj.service.PhoneService;
import com.wjj.vo.DataVo;
import com.wjj.vo.PhoneInfoVo;
import com.wjj.vo.SpecsPackageVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PhoneServiceImplTest {

    @Autowired
    private PhoneService phoneService;
    @Test
    void findDateVo() {
        DataVo dataVo = phoneService.findDateVo();
        int id =0;
    }

    @Test
    void findPhoneInfoVoByCategoryType(){
        List<PhoneInfoVo> phoneInfoVoList = phoneService.findPhoneInfoVoByCategoryType(2);
        int id = 0;
    }

    @Test
    void findSku(){
        SpecsPackageVo specsPackageVo = phoneService.findSpecsByPhoneId(1);
        int id = 0;

    }

    @Test
    void subStock(){
        phoneService.subStock(2,4);
    }
}
