package com.example.sell.service;

import com.example.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

    OrderDTO create(OrderDTO orderDTO);

    OrderDTO findOne(String orderId);

    Page<OrderDTO> findList(String buyerOpenId, Pageable pageable);

    OrderDTO cancel(OrderDTO orderDTO);

    OrderDTO finish(OrderDTO orderDTO);

    OrderDTO paid(OrderDTO orderDTO);

}
