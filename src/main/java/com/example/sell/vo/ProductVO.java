package com.example.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品 + 类目
 *
 * @author gaozhuo
 * @date 2018/1/24
 */
@Data
public class ProductVO {
    @JsonProperty("id")
    private Integer categoryId;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

}
