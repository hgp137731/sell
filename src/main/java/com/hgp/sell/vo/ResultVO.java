package com.hgp.sell.vo;

import lombok.Data;

/**
 *  HTTP 请求返回给前端的最外层对象
 * @Author: GuangPeng He
 * @Date: 2020/11/27 22:42
 * @Remark AoLiGei
 */
@Data
public class ResultVO<T> {

    /* 错误码 */
    private Integer code;

    /* 返回的消息 */
    private String msg;

    /* 返回的结果集 */
    private T data;

    public ResultVO() {
    }

    public ResultVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
