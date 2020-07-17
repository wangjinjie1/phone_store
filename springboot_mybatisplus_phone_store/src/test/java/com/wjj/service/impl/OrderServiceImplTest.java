package com.wjj.service.impl;

import com.wjj.Util.KeyUtil;
import com.wjj.dto.OrderDTO;
import com.wjj.service.OrderService;
import com.wjj.vo.OrderDetailVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceImplTest {


    @Autowired
    private OrderService orderService;
    @Test
    void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("zhangsan");
        orderDTO.setBuyerPhone("13577778888");
        orderDTO.setBuyerAddress("广东省深圳市罗湖区科技路123号");
        orderDTO.setSpecsId(1);
        orderDTO.setPhoneQuantity(1);

        //System.out.println(KeyUtil.createUniqueKey());
        OrderDTO dto = orderService.create(orderDTO);
        System.out.println(dto);
    }
    @Test
    void findDetail(){
        OrderDetailVo orderDetailVo = orderService.findOrderDetailByOrderId("1594694489216944317");
        int id = 0;

    }
}
