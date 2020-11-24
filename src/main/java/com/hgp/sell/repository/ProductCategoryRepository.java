package com.hgp.sell.repository;

import com.hgp.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: GuangPeng He
 * @Date: 2020/11/24 20:51
 * @Remark AoLiGei
 */
public interface ProductCategoryRepository extends  JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
