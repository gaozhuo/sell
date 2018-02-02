package com.example.sell.repository;

import com.example.sell.dataobject.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void save() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("222222");
        orderDetail.setOrderId("222222");
        orderDetail.setProductId("1234567");
        orderDetail.setProductName("xiao mi");
        orderDetail.setProductPrice(new BigDecimal(2000));
        orderDetail.setProductQuantity(2);
        orderDetail.setProductIcon("http://xxx.com");

        OrderDetail result = repository.save(orderDetail);
        assertNotNull(result);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = repository.findByOrderId("222222");
        assertNotEquals(0, orderDetailList.size());
    }
}