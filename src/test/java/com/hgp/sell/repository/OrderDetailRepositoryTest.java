package com.hgp.sell.repository;

import com.hgp.sell.dataobject.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: GuangPeng He
 * @Date: 2020/11/28 0:39
 * @Remark AoLiGei
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void findByOrderId() {
        final List<OrderDetail> byOrderId = repository.findByOrderId("123456");
        System.out.println(byOrderId);
    }

    @Test
    public void save() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123456");
        orderDetail.setOrderId("123456");
        orderDetail.setProductId("123456");
        orderDetail.setProductName("小龙虾");
        orderDetail.setProductPrice(new BigDecimal(25));
        orderDetail.setProductQuantity(10);
        orderDetail.setProductIcon("XXXXXXXXXXXXXXXX");
        final OrderDetail save = repository.save(orderDetail);
        System.out.println(save);
    }
}