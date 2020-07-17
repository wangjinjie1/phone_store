package com.wjj.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wjj.entity.PhoneCategory;
import com.wjj.entity.PhoneSpecs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class PhoneSpecMapperTest {

    @Autowired
    private PhoneSpecMapper phoneSpecMapper;
    @Test
    void selectAll(){
        List<PhoneSpecs> phoneSpecs = phoneSpecMapper.selectList(null);
        phoneSpecs.forEach(System.out::println);

    }

    @Test
    void selectByPhoneId(){
        Map<String, Object> map = new HashMap<>();
        // 此处 phone_id 为数据库中的表单名
        map.put("phone_id",1);
        List<PhoneSpecs> phoneSpecs = phoneSpecMapper.selectByMap(map);
        phoneSpecs.forEach(System.out::println);
    }

    @Test
    void selectByPhoneId2(){
        QueryWrapper<PhoneSpecs> queryWrapper = new QueryWrapper();
        queryWrapper.eq("phone_id", 1);

        List<PhoneSpecs> phoneSpecs = phoneSpecMapper.selectList(queryWrapper);
        phoneSpecs.forEach(System.out::println);

    }
}
