package com.example.sell.enums;

import lombok.Getter;

/**
 * 返回给前端的信息
 *
 * @author gaozhuo
 * @date 2018/2/19
 */
@Getter
public enum ResultEnum {
    PARAM_ERROR(1, "参数错误"),

    PRODUCT_NO_EXIT(10, "商品不存在"),

    PRODUCT_STOCK_ERROR(11, "商品库存错误"),

    ORDER_NOT_EXIT(12, "订单不存在"),

    ORDER_DETAIL_NOT_EXIT(13, "订单详情不存在"),

    ORDER_STATUS_NOT_ERROR(14, "订单状态错误"),

    ORDER_DETAIL_EMPTY(15, "订单详情为空"),

    ORDER_UPDATE_FAIL(16, "更新订单失败"),

    ORDER__PAY_STATUS_NOT_ERROR(17, "订单支付状态错误"),

    CART_EMPTY(18, "购物车为空"),

    ORDER_OWNER_ERROR(19, "不是该用户的订单");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
