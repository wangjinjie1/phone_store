package com.wjj;

import com.wjj.entity.PhoneCategory;
import com.wjj.mapper.PhoneCategoryMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {




    @Autowired
    private PhoneCategoryMapper phoneCategoryMapper;
    @Test
    void contextLoads() {
    }

    @Test
    void testFindAll(){
        List<PhoneCategory> list = phoneCategoryMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    void  testFindByCategory(){
        Map<String, Object> map = new HashMap<>();
        // 不支持 _ 自动转化为 大写
        map.put("category_type",3);
        System.out.println(phoneCategoryMapper.selectByMap(map));

        List<PhoneCategory> list = phoneCategoryMapper.selectList(null);
        System.out.println(list.get(0).getCategoryType());
    }

}
