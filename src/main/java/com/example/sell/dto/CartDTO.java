package com.example.sell.dto;

import lombok.Data;

/**
 * 购物车
 *
 * @author gaozhuo
 * @date 2018/2/21
 */
@Data
public class CartDTO {
    private String productId;

    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
