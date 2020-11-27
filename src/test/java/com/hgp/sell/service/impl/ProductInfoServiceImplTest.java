package com.hgp.sell.service.impl;

import com.hgp.sell.dataobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * @Author: GuangPeng He
 * @Date: 2020/11/27 21:55
 * @Remark AoLiGei
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductPrice(new BigDecimal(29.3));
        productInfo.setProductStatus(0);
        productInfo.setProductStock(120);
        productInfo.setProductDescription("哇塞2");
        productInfo.setCategoryType(1);
        productInfo.setProductIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606495716075&di=e6029a5adc53ec3bde511702572f2469&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fw%3D580%2Fsign%3D26b8b58a8a13632715edc23ba18ea056%2F623afdf81a4c510fee9ecb4c6059252dd52aa588.jpg");
        final ProductInfo save = productInfoService.save(productInfo);
        System.out.println(save);
    }

    @Test
    public void findOne() {
        final ProductInfo one = productInfoService.findOne("123456");
        System.out.println(one);
    }

    @Test
    public void findUpAll() {
        final List<ProductInfo> upAll = productInfoService.findUpAll();
        System.out.println(upAll.toString());
    }

    @Test
    public void findAll() {
        final PageRequest of = PageRequest.of(0, 2);
        final Page<ProductInfo> all = productInfoService.findAll(of);
        final List<ProductInfo> content = all.getContent();
        System.out.println(content);
    }
}