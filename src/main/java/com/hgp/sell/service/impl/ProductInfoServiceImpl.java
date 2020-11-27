package com.hgp.sell.service.impl;

import com.hgp.sell.dataobject.ProductInfo;
import com.hgp.sell.dto.CartDTO;
import com.hgp.sell.enums.ProductStatusEnum;
import com.hgp.sell.enums.ResultEnum;
import com.hgp.sell.exception.SellException;
import com.hgp.sell.repository.ProductInfoRepository;
import com.hgp.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 *  商品Service
 * @Author: GuangPeng He
 * @Date: 2020/11/27 21:46
 * @Remark AoLiGei
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public ProductInfo findOne(String productId) {
        Optional<ProductInfo> optionalProductInfo = repository.findById(productId);
        if(!optionalProductInfo.isPresent())
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        return optionalProductInfo.get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        cartDTOList.forEach(cartDTO -> {
            Optional<ProductInfo> productInfoOptional = repository.findById(cartDTO.getProductId());
            if(!productInfoOptional.isPresent())
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);

            ProductInfo productInfo = productInfoOptional.get();

            if(productInfo == null)
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);

            //TODO 超卖的问题处理

            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if(result < 0)
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            productInfo.setProductStock(result);
            repository.save(productInfo);
        });

    }
}
