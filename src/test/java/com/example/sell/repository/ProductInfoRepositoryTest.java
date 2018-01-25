package com.example.sell.repository;

import com.example.sell.dataobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.text.normalizer.UBiDiProps;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    ProductInfoRepository repository;

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("iphone 8");
        productInfo.setProductDescription("very nice");
        productInfo.setProductPrice(new BigDecimal(5000));
        productInfo.setProductStock(20);
        productInfo.setProductStatus(0);
        productInfo.setProductIcon("http://xxx.com");
        productInfo.setCategoryType(2);

        ProductInfo result = repository.save(productInfo);
        assertNotNull(result);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfoList = repository.findByProductStatus(0);
        assertNotEquals(0, productInfoList.size());
    }
}