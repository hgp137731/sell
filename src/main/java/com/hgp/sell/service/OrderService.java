package com.hgp.sell.service;

import com.hgp.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author: GuangPeng He
 * @Date: 2020/11/28 0:43
 * @Remark AoLiGei
 */
public interface OrderService {

    /* 创建订单 */
    OrderDTO create(OrderDTO orderDTO);

    /* 查询单个订单 */
    OrderDTO findOne(String orderId);

    /* 查询订单列表 */
    Page<OrderDTO> findPage(String buyerOpenid, Pageable pageable);

    /* 取消订单 */
    OrderDTO cancel(OrderDTO orderDTO);

    /* 完结订单 */
    OrderDTO finish(OrderDTO orderDTO);

    /* 支付订单 */
    OrderDTO paid(OrderDTO orderDTO);

}
