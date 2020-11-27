package com.hgp.sell.service.impl;

import com.hgp.sell.dataobject.ProductCategory;
import com.hgp.sell.enums.ResultEnum;
import com.hgp.sell.exception.SellException;
import com.hgp.sell.repository.ProductCategoryRepository;
import com.hgp.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 类目Service
 *
 * @Author: GuangPeng He
 * @Date: 2020/11/27 21:27
 * @Remark AoLiGei
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        Optional<ProductCategory> productCategoryOptional = repository.findById(categoryId);
        if(!productCategoryOptional.isPresent())
            throw new SellException(ResultEnum.CATEGORY_NOT_EXIST);
        return productCategoryOptional.get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    @Transactional
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
