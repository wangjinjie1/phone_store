package com.wjj.service.impl;

import com.wjj.Util.KeyUtil;
import com.wjj.dto.OrderDTO;
import com.wjj.entity.OrderMaster;
import com.wjj.entity.PhoneInfo;
import com.wjj.entity.PhoneSpecs;
import com.wjj.enums.PayStatusEnum;
import com.wjj.enums.ResultEnum;
import com.wjj.exception.PhoneException;
import com.wjj.mapper.OrderMasterMapper;
import com.wjj.mapper.PhoneInfoMapper;
import com.wjj.mapper.PhoneSpecMapper;
import com.wjj.service.PhoneService;
import com.wjj.vo.OrderDetailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class OrderServiceImpl implements com.wjj.service.OrderService {

    @Autowired
    private PhoneSpecMapper phoneSpecMapper;

    @Autowired
    private PhoneInfoMapper phoneInfoMapper;

    @Autowired
    private OrderMasterMapper orderMasterMapper;

    @Autowired
    private PhoneService phoneService;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        OrderMaster orderMaster = new OrderMaster();
        // 完成 buyerName，buyerPhone，buyerAddress的赋值
        BeanUtils.copyProperties(orderDTO,orderMaster);


        PhoneSpecs phoneSpecs = phoneSpecMapper.selectById(orderDTO.getSpecsId());
        if (phoneSpecs == null) {
            // {} 占位符，输出其后的参数orderMaster
            log.error("【创建订单】规格不存在,phoneSpecs={}",phoneSpecs);
            throw new PhoneException(ResultEnum.SPECS_NOT_EXIST);
        }
        // 完成 specsId，specsName，specsPrice
        BeanUtils.copyProperties(phoneSpecs,orderMaster);

        PhoneInfo phoneInfo = phoneInfoMapper.selectById(phoneSpecs.getPhoneId());
        if (phoneInfo == null) {
            // {} 占位符，输出其后的参数orderMaster
            log.error("【创建订单】手机不存在,phoneInfo={}",phoneInfo);
            throw new PhoneException(ResultEnum.PHONE_NOT_EXIST);
        }
        // 完成 phoneId，phoneName，phoneQuantity，phoneIcon
        BeanUtils.copyProperties(phoneInfo,orderMaster);

        //计算总价 完成 orderAmount
        BigDecimal orderAmount = new BigDecimal(0);
        orderAmount = phoneSpecs.getSpecsPrice().divide(new BigDecimal(100))
                .multiply(new BigDecimal(orderDTO.getPhoneQuantity()))
                .add(orderAmount)
                .add(new BigDecimal(10));
        orderMaster.setOrderAmount(orderAmount);
        // 完成 orderId
        orderMaster.setOrderId(KeyUtil.createUniqueKey());
        orderDTO.setOrderId(orderMaster.getOrderId());
        // 完成 paystatus
        orderMaster.setPayStatus(PayStatusEnum.UNPAID.getCode());
        orderMasterMapper.insert(orderMaster);

        phoneService.subStock(orderDTO.getSpecsId(),orderDTO.getPhoneQuantity());
        return orderDTO;
    }

    @Override
    public OrderDetailVo findOrderDetailByOrderId(String orderId) {
        OrderDetailVo orderDetailVo = new OrderDetailVo();
        OrderMaster orderMaster = orderMasterMapper.selectById(orderId);
        if(orderMaster == null){
            log.error("【查询订单】订单不存在,orderMaster={}",orderMaster);
            throw new PhoneException(ResultEnum.ORDER_NOT_EXIST);
        }
        // 类型与属性名都要一致才能完成复制 orderMaster中 specsPrice 为 BigDecimal
        // 而 OrderDetailVo 为 String，需要手动set
        BeanUtils.copyProperties(orderMaster,orderDetailVo);
        orderDetailVo.setSpecsPrice(orderMaster.getSpecsPrice().divide(new BigDecimal(100))+".00");

        return orderDetailVo;
    }

    @Override
    public String pay(String orderId) {
        OrderMaster orderMaster = orderMasterMapper.selectById(orderId);
        if (orderMaster == null) {
            // {} 占位符，输出其后的参数orderMaster
            log.error("【支付订单】订单不存在,orderMaster={}",orderMaster);
            throw new PhoneException(ResultEnum.ORDER_NOT_EXIST);
        }
        if (orderMaster.getPayStatus().equals(PayStatusEnum.UNPAID.getCode())) {
            orderMaster.setPayStatus(PayStatusEnum.PAID.getCode());
            orderMasterMapper.updateById(orderMaster);
        }else {
            log.error("【支付订单】订单已支付,orderMaster={}",orderMaster);
        }
        return orderId;
    }
}
