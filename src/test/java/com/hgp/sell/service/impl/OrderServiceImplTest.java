package com.hgp.sell.service.impl;

import com.hgp.sell.dataobject.OrderDetail;
import com.hgp.sell.dto.OrderDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: GuangPeng He
 * @Date: 2020/11/28 1:23
 * @Remark AoLiGei
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void create() {
        //name: "张三"
        //phone: "18868822111"
        //address: "慕课网总部"
        //openid: "ew3euwhd7sjw9diwkq" //用户的微信openid
        //items: [{
        //    productId: "1423113435324",
        //    productQuantity: 2 //购买数量
        //}]
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("张三");
        orderDTO.setBuyerPhone("12345678911");
        orderDTO.setBuyerAddress("广州");
        orderDTO.setBuyerOpenid("abc123456");

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("123456");
        orderDetail.setProductQuantity(10);
        orderDetailList.add(orderDetail);

        orderDetail = new OrderDetail();
        orderDetail.setProductId("1111111");
        orderDetail.setProductQuantity(5);
        orderDetailList.add(orderDetail);
        orderDTO.setOrderDetailList(orderDetailList);
        final OrderDTO orderDTO1 = orderService.create(orderDTO);
        System.out.println(orderDTO1);
    }

    @Test
    public void findOne() {
        final OrderDTO one = orderService.findOne("1606498435404678001");
        System.out.println(one);
    }

    @Test
    public void findPage() {
        final Page<OrderDTO> orderDTOPage = orderService.findPage("abc123456", PageRequest.of(0, 3));
        System.out.println(orderDTOPage.getContent().toString());
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}