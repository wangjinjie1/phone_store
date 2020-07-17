package com.wjj.controller;

import com.wjj.Util.ResultVoUtil;
import com.wjj.dto.OrderDTO;
import com.wjj.exception.PhoneException;
import com.wjj.form.OrderForm;
import com.wjj.service.OrderService;
import com.wjj.service.PhoneService;
import com.wjj.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderHandler {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PhoneService phoneService;

    @PostMapping("/create")
    public ResultVo create(@Valid @RequestBody OrderForm orderForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("【创建订单】参数错误,orderForm={}",orderForm);
            throw new PhoneException(bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerPhone(orderForm.getTel());
        orderDTO.setSpecsId(orderForm.getSpecsId());
        orderDTO.setPhoneQuantity(orderForm.getQuantity());

        OrderDTO dto = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId",dto.getOrderId());

        return ResultVoUtil.success(map);
    }

    @GetMapping("/detail/{orderId}")
    public ResultVo findOrderDetail(@PathVariable("orderId") String orderId){
        return ResultVoUtil.success(orderService.findOrderDetailByOrderId(orderId));
    }

    @PutMapping("/pay/{orderId}")
    public ResultVo pay(@PathVariable("orderId") String orderId){
        Map<String, String> map = new HashMap<>();
        map.put("orderId",orderService.pay(orderId));
        return ResultVoUtil.success(map);
    }

}
