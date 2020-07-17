package com.wjj.mapper;

import com.wjj.entity.PhoneInfo;
import com.wjj.mapper.PhoneInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PhoneInfoMapperTest {

    @Autowired
    private PhoneInfoMapper infoMapper;

    @Test
    void testSelectAll(){
        List<PhoneInfo> phoneInfos = infoMapper.selectList(null);
        phoneInfos.forEach(System.out::println);
    }

    @Test
    void testSelectByCategoryType(){
        Map<String, Object> map = new HashMap<>();
        map.put("category_type",1);
        List<PhoneInfo> phoneInfos = infoMapper.selectByMap(map);
        phoneInfos.forEach(System.out::println);
    }

}
