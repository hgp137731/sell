package com.hgp.sell.dto;

import com.hgp.sell.dataobject.OrderDetail;
import com.hgp.sell.enums.OrderStatusEnum;
import com.hgp.sell.enums.PayStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author: GuangPeng He
 * @Date: 2020/11/28 0:46
 * @Remark AoLiGei
 */
@Data
public class OrderDTO {
    /* 买家名称 */
    private String buyerName;

    /* 买家手机号 */
    private String buyerPhone;

    /* 买家地址 */
    private String buyerAddress;

    /* 买家微信Openid */
    private String buyerOpenid;

    /* 订单总金额 */
    private BigDecimal orderAmount;

    /* 订单状态 */
    private Integer orderStatus;

    /* 支付状态 */
    private Integer payStatus;

    private Date createTime;

    private Date updateTime;

    private List<OrderDetail> orderDetailList;

}
