package com.hgp.sell.repository;

import com.hgp.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 订单DAO
 * @Author: GuangPeng He
 * @Date: 2020/11/28 0:28
 * @Remark AoLiGei
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

    /**
     * 根据买家openid 查询该买家的所有订单
     * @param buyerOpenid
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
