package com.wjj.mapper;

import com.wjj.entity.BuyerAddress;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BuyerAddressMapperTest {

    @Autowired
    private BuyerAddressMapper buyerAddressMapper;

    @Test
    void selectAll(){
        List<BuyerAddress> buyerAddresses = buyerAddressMapper.selectList(null);
        buyerAddresses.forEach(System.out::println);
    }

    @Test
    void save(){
        BuyerAddress buyerAddress = new BuyerAddress();
        buyerAddress.setAreaCode("110101");
        buyerAddress.setBuyerAddress("广东省深圳市铜锣湾区1234号");
        buyerAddress.setBuyerName("小红");
        buyerAddress.setBuyerPhone("15978756454");
        System.out.println(buyerAddressMapper.insert(buyerAddress));
    }

    @Test
    void update(){
        BuyerAddress buyerAddress = buyerAddressMapper.selectById(36);
        buyerAddress.setBuyerName("小红");
        System.out.println(buyerAddressMapper.updateById(buyerAddress));
    }
}
