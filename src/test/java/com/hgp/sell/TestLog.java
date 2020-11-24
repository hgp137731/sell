package com.hgp.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: GuangPeng He
 * @Date: 2020/11/24 20:33
 * @Remark AoLiGei
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestLog {

    @Test
    public void test() {
        log.info("我是第一条info消息");
        log.error("我是第一条error消息");
        log.warn("我是第一条warn消息");
    }
}
