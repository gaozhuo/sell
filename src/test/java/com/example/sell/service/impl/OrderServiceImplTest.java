package com.example.sell.service.impl;

import com.example.sell.dataobject.OrderDetail;
import com.example.sell.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {
    private static final String BUYER_OPENID = "123456";
    private static final String ORDER_ID = "1519817292178974990";

    @Autowired
    OrderServiceImpl orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("张三");
        orderDTO.setBuyerAddress("深圳市");
        orderDTO.setBuyerPhone("13812345678");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setProductId("111111");
        orderDetail1.setProductQuantity(1);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setProductId("222222");
        orderDetail2.setProductQuantity(2);

        orderDetailList.add(orderDetail1);
        orderDetailList.add(orderDetail2);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);

        log.info("【创建订单】 result={}", result);


    }

    @Test
    public void findOne() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        log.info("【查询单个订单】 result={}", orderDTO);
        assertEquals(ORDER_ID, orderDTO.getOrderId());

    }

    @Test
    public void findList() {
        Pageable pageable = new PageRequest(0, 2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID, pageable);
        assertNotEquals(0, orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}