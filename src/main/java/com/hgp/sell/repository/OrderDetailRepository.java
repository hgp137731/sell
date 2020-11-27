package com.hgp.sell.repository;

import com.hgp.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 订单详情DAO
 * @Author: GuangPeng He
 * @Date: 2020/11/28 0:31
 * @Remark AoLiGei
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

    List<OrderDetail> findByOrderId(String orderId);
}
