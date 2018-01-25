package com.example.sell.repository;

import com.example.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品信息DAO
 *
 * @author gaozhuo
 * @date 2018/1/23
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {


    List<ProductInfo> findByProductStatus(Integer productStatus);
}
