package com.example.sell.repository;

import com.example.sell.dataobject.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void save() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("222222");
        orderMaster.setBuyerName("李四");
        orderMaster.setBuyerAddress("深圳市南山区");
        orderMaster.setBuyerPhone("13838383838");
        orderMaster.setOrderAmount(new BigDecimal(9.8));
        orderMaster.setBuyerOpenid("1010101");

        OrderMaster result = repository.save(orderMaster);
        assertNotNull(result);

    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest request = new PageRequest(1, 1);
        Page<OrderMaster> page = repository.findByBuyerOpenid("1010101", request);
        assertNotEquals(0, page.getTotalElements());
    }
}