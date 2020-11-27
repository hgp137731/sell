package com.hgp.sell.enums;

import lombok.Getter;

/**
 * @Author: GuangPeng He
 * @Date: 2020/11/28 0:53
 * @Remark AoLiGei
 */
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "库存不足"),
    CATEGORY_NOT_EXIST(20, "类目不存在"),
    ORDER_NOT_EXIST(30, "订单不存在"),
    ORDER_DETAIL_NOT_EXIST(31, "订单详情获取失败")
    ;


    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
