package com.wjj.mapper;

import com.wjj.entity.OrderMaster;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderMasterMapperTest {

    @Autowired
    private OrderMasterMapper orderMasterMapper;

    @Test
    void selectAll(){
        List<OrderMaster> orderMasters = orderMasterMapper.selectList(null);
        orderMasters.forEach(System.out::println);
    }

    @Test
    void save(){
        OrderMaster orderMaster = orderMasterMapper.selectById("1594539201410963190");
        orderMaster.setBuyerPhone("13333378901");
        System.out.println(orderMasterMapper.insert(orderMaster));
    }
}
