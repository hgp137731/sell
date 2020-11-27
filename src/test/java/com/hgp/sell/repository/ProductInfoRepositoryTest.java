package com.hgp.sell.repository;

import com.hgp.sell.dataobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: GuangPeng He
 * @Date: 2020/11/27 21:39
 * @Remark AoLiGei
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void findByProductStatus() {
        final List<ProductInfo> byProductStatus = repository.findByProductStatus(0);
        System.out.println(byProductStatus.toString());

    }

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("小龙虾");
        productInfo.setProductPrice(new BigDecimal(25.3));
        productInfo.setProductStatus(0);
        productInfo.setProductStock(100);
        productInfo.setProductDescription("哇塞");
        productInfo.setCategoryType(1);
        productInfo.setProductIcon("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1606484516&di=1d6894f503ae9332f117fbe77b0c636c&src=http://hbimg.b0.upaiyun.com/d26efdce0e35938bb66a67c3937d71c913e58de8380c2-CKM7DO_fw658");
        final ProductInfo save = repository.save(productInfo);
        System.out.println(save);
    }
}