package com.hgp.sell.enums;

import lombok.Getter;

/**
 * productInfo Status Enum
 * @Author: GuangPeng He
 * @Date: 2020/11/27 21:50
 * @Remark AoLiGei
 */
@Getter
public enum ProductStatusEnum {
    UP(0,"上架"),
    DOWN(1,"下架")
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
