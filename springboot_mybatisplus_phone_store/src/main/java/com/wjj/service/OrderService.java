package com.wjj.service;

import com.wjj.dto.OrderDTO;
import com.wjj.vo.OrderDetailVo;

public interface OrderService {
    public OrderDTO create(OrderDTO orderDTO);
    public OrderDetailVo findOrderDetailByOrderId(String orderId);
    public String pay(String orderId);
}
