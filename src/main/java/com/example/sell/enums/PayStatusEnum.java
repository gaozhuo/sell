package com.example.sell.enums;

import lombok.Getter;

/**
 * 支付状态
 *
 * @author gaozhuo
 * @date 2018/1/31
 */
@Getter
public enum PayStatusEnum {
    WAIT(0, "等待志芳"),
    SUCCESS(1, "支付成功");

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
