package com.example.sell.service;

import com.example.sell.dto.OrderDTO;

/**
 * @author gaozhuo
 * @date 2018/3/19
 */
public interface BuyerService {

    OrderDTO findOrderOne(String openid, String orderId);

    OrderDTO cancelOrder(String openid, String orderId);
}
