package com.hgp.sell.service;

import com.hgp.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * @Author: GuangPeng He
 * @Date: 2020/11/27 21:25
 * @Remark AoLiGei
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

}
