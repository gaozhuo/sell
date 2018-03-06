package com.example.sell.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 创建订单表单
 *
 * @author gaozhuo
 * @date 2018/3/5
 */
@Data
public class OrderForm {
    @NotEmpty(message = "姓名必填")
    private String name;

    @NotEmpty(message = "手机号必填")
    private String phone;

    @NotEmpty(message = "地址必填")
    private String address;

    @NotEmpty(message = "openid必填")
    private String openid;

    @NotEmpty(message = "购物车必填")
    private String items;
}
