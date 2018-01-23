package com.example.sell.repository;

import com.example.sell.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;
import java.awt.image.RescaleOp;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() throws Exception {
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory);
    }

    @Test
    public void saveTest() throws Exception{
        ProductCategory productCategory = repository.findOne(3);
        productCategory.setCategoryType(12);
        repository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> categoryTypeList = Arrays.asList(2,3,4,12);
        List<ProductCategory> productCategoryList = repository.findByCategoryTypeIn(categoryTypeList);
        assertEquals(2,productCategoryList.size());
    }
}