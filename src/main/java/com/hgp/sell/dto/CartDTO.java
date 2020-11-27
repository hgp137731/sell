package com.hgp.sell.dto;

import lombok.Data;

/**
 * 购物车
 * @Author: GuangPeng He
 * @Date: 2020/11/28 1:13
 * @Remark AoLiGei
 */
@Data
public class CartDTO {
    /* 商品标识 */
    private String productId;

    /* 总数 */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
