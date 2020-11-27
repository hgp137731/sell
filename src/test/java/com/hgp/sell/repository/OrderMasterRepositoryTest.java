package com.hgp.sell.repository;

import com.hgp.sell.dataobject.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: GuangPeng He
 * @Date: 2020/11/28 0:32
 * @Remark AoLiGei
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void findByBuyerOpenid() {
        final Page<OrderMaster> orderMasterPage = repository.findByBuyerOpenid("abc123456", PageRequest.of(0, 5));
        final List<OrderMaster> content = orderMasterPage.getContent();
        System.out.println(content.toString());
    }

    @Test
    public void save() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123457");
        orderMaster.setBuyerName("HGP");
        orderMaster.setBuyerPhone("13542123215");
        orderMaster.setBuyerAddress("广州市黄浦区");
        orderMaster.setBuyerOpenid("abc123456");
        orderMaster.setOrderAmount(new BigDecimal(20));
        final OrderMaster save = repository.save(orderMaster);
        System.out.println(save);
    }
}