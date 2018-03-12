package com.example.sell.controller;

import com.example.sell.converter.OrderForm2OrderDTO;
import com.example.sell.dto.OrderDTO;
import com.example.sell.enums.ResultEnum;
import com.example.sell.exception.SellException;
import com.example.sell.form.OrderForm;
import com.example.sell.service.OrderService;
import com.example.sell.utils.ResultVOUtils;
import com.example.sell.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     *
     * @param orderForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数错误, orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTO.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空, ");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO result = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultVOUtils.success(map);
    }

    /**
     * 订单列表
     *
     * @param openid openid
     * @param page   起始页
     * @param size   每页大小
     * @return
     */
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.error("【创建订单】 openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        Pageable pageable = new PageRequest(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, pageable);
        return ResultVOUtils.success(orderDTOPage.getContent());
    }

    /**
     * 订单详情
     *
     * @param openid  openid
     * @param orderId 订单id
     * @return
     */
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam String openid, @RequestParam String orderId) {
        // TODO 不安全
        OrderDTO orderDTO = orderService.findOne(orderId);
        return ResultVOUtils.success(orderDTO);
    }

    /**
     * 取消订单
     *
     * @param openid  openid
     * @param orderId 订单id
     * @return
     */
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam String openid, @RequestParam String orderId) {
        // TODO 不安全
        OrderDTO orderDTO = orderService.findOne(orderId);
        orderService.cancel(orderDTO);
        return ResultVOUtils.success();
    }
}
