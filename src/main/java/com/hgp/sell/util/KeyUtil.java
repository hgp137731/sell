package com.hgp.sell.util;

import java.util.Random;

/**
 * @Author: GuangPeng He
 * @Date: 2020/11/28 1:02
 * @Remark AoLiGei
 */
public class KeyUtil {

    /**
     * 生成唯一主键
     * 格式： 时间+ 随机数
     * @return
     */
    public static synchronized String getUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
