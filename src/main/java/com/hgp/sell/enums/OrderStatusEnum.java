package com.hgp.sell.enums;

import lombok.Getter;

/**
 * @Author: GuangPeng He
 * @Date: 2020/11/28 0:21
 * @Remark AoLiGei
 */
@Getter
public enum  OrderStatusEnum {
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消")
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
