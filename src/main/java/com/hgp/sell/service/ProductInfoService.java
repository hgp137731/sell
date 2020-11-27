package com.hgp.sell.service;

import com.hgp.sell.dataobject.ProductInfo;
import com.hgp.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: GuangPeng He
 * @Date: 2020/11/27 21:45
 * @Remark AoLiGei
 */
public interface ProductInfoService {


    ProductInfo save(ProductInfo productInfo);

    ProductInfo findOne(String productId);

    /**
     * 查询在架商品
     * @return
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    // 减库存
    void decreaseStock(List<CartDTO> cartDTOList);


}
