package com.hgp.sell.util;

import com.hgp.sell.vo.ResultVO;

/**
 *  返回结果集工具
 * @Author: GuangPeng He
 * @Date: 2020/11/27 23:14
 * @Remark AoLiGei
 */
public class ResultVOUnit {

    public static ResultVO success(Object object) {
        return  new ResultVO(0,"成功",object);
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code,String msg){
        return new ResultVO(code,msg,null);
    }
}
