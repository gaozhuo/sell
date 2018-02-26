package com.example.sell.dto;

import com.example.sell.dataobject.OrderDetail;
import com.example.sell.enums.OrderStatusEnum;
import com.example.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * order数据传输对象
 *
 * @author gaozhuo
 * @date 2018/2/19
 */
@Data
public class OrderDTO {
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus;

    private Integer payStatus;

    private Date createTime;

    private Date updateTime;

    private List<OrderDetail> orderDetailList;
}
