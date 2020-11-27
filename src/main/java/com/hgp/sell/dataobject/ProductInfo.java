package com.hgp.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 *  商品实体类
 * @Author: GuangPeng He
 * @Date: 2020/11/27 21:34
 * @Remark AoLiGei
 */
@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    /* 商品名称 */
    private String productName;

    /* 商品单价 */
    private BigDecimal productPrice;

    /* 库存 */
    private Integer productStock;

    /* 描述 */
    private String productDescription;

    /* 小图 */
    private String productIcon;

    /* 商品状态 0正常 1下架 */
    private Integer productStatus;

    /* 商品类型 */
    private Integer categoryType;

}
