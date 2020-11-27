package com.hgp.sell.exception;

import com.hgp.sell.enums.ResultEnum;

/**
 * @Author: GuangPeng He
 * @Date: 2020/11/28 0:53
 * @Remark AoLiGei
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
