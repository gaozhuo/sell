package com.example.sell.controller;

import com.example.sell.dataobject.ProductCategory;
import com.example.sell.dataobject.ProductInfo;
import com.example.sell.service.CategoryService;
import com.example.sell.service.ProductService;
import com.example.sell.service.impl.ProductServiceImpl;
import com.example.sell.utils.ResultVOUtils;
import com.example.sell.vo.ProductInfoVO;
import com.example.sell.vo.ProductVO;
import com.example.sell.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 *
 * @author gaozhuo
 * @date 2018/1/24
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "获取在线商品列表", notes = "获取在线商品列表")
    @GetMapping("/list")
    public ResultVO list() {

        List<ProductInfo> productInfoList = productService.findUpAll();

        List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        List<ProductVO> productVOList = new ArrayList<>();

        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();

            productVO.setCategoryId(productCategory.getCategoryId());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {

                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }

            productVO.setProductInfoVOList(productInfoVOList);

            productVOList.add(productVO);

        }

           return ResultVOUtils.success(productVOList);
    }

    /**
     *
     * @param name 姓名
     * @param price 价格
     * @param type 类型
     * @return
     */
    @ApiOperation(value = "添加商品", notes = "添加一个商品")
    @PostMapping("/add")
    public ResultVO add(@RequestParam(required = true) String name, double price, Integer type) {
        return ResultVOUtils.success();
    }
}
