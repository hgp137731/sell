package com.hgp.sell.repository;

import com.hgp.sell.dataobject.ProductCategory;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


/**
 * @Author: GuangPeng He
 * @Date: 2020/11/24 20:52
 * @Remark AoLiGei
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findAll() {
        List<ProductCategory> list = repository.findAll();
        System.out.println(list);
    }

    @Test
    public void save() {
        Optional<ProductCategory> productCategoryOptional = repository.findById(2);
        ProductCategory productCategory = productCategoryOptional.get();
        productCategory.setCategoryName("热销榜1");
        repository.save(productCategory);
        System.out.println(productCategory);
    }

    @Test
    public void findCategoryList(){
        val byCategoryTypeIn = repository.findByCategoryTypeIn(Arrays.asList(1, 2, 3));
        System.out.println(byCategoryTypeIn.toString());

    }

}