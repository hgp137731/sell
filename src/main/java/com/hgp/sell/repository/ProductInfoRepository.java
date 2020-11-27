package com.hgp.sell.repository;

import com.hgp.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *  商品DAO
 * @Author: GuangPeng He
 * @Date: 2020/11/27 21:37
 * @Remark AoLiGei
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
