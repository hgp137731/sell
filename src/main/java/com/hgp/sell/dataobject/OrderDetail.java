package com.hgp.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 订单详情实体
 * @Author: GuangPeng He
 * @Date: 2020/11/28 0:25
 * @Remark AoLiGei
 */
@Entity
@Data
public class OrderDetail {

    @Id
    private String detailId;

    /* 订单id */
    private String orderId;

    /* 商品id */
    private String productId;

    /* 商品名称 */
    private String productName;

    /* 单价 */
    private BigDecimal productPrice;

    /* 商品数量 */
    private Integer productQuantity;

    /* 商品图片链接 */
    private String productIcon;

}
