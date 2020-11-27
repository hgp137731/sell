package com.hgp.sell.controller;

import com.hgp.sell.dataobject.ProductCategory;
import com.hgp.sell.dataobject.ProductInfo;
import com.hgp.sell.service.CategoryService;
import com.hgp.sell.service.ProductInfoService;
import com.hgp.sell.util.ResultVOUnit;
import com.hgp.sell.vo.ProductInfoVO;
import com.hgp.sell.vo.ProductVO;
import com.hgp.sell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  买家业务
 * @Author: GuangPeng He
 * @Date: 2020/11/27 22:40
 * @Remark AoLiGei
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {
        // 查询所有的上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        // 查询类目
        List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        List<ProductVO> productVOList = new ArrayList<>();
        // 拼接数据
        productCategoryList.forEach(e -> {
            ProductVO productVO = new ProductVO();
            BeanUtils.copyProperties(e,productVO);

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            productInfoList.forEach(a -> {
                if(e.getCategoryType() == a.getCategoryType()) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(a,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            });
            productVO.setFoods(productInfoVOList);
            productVOList.add(productVO);
        });

        return ResultVOUnit.success(productVOList);
    }
}
