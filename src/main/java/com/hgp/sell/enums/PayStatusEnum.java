package com.hgp.sell.enums;

import lombok.Getter;

/**
 * @Author: GuangPeng He
 * @Date: 2020/11/28 0:23
 * @Remark AoLiGei
 */
@Getter
public enum PayStatusEnum {
    WAIT(0,"未支付"),
    SUCCESS(1,"支付成功")
    ;

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
