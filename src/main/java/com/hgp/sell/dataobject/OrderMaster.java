package com.hgp.sell.dataobject;

import com.hgp.sell.enums.OrderStatusEnum;
import com.hgp.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 *  订单主实体
 * @Author: GuangPeng He
 * @Date: 2020/11/28 0:19
 * @Remark AoLiGei
 */
@Entity
@DynamicUpdate
@Data
public class OrderMaster {

    @Id
    private String orderId;

    /* 买家名称 */
    private String buyerName;

    /* 买家手机号 */
    private String buyerPhone;

    /* 买家地址 */
    private String buyerAddress;

    /* 买家微信Openid */
    private String buyerOpenid;

    /* 订单总金额 */
    private BigDecimal orderAmount;

    /* 订单状态 */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /* 支付状态 */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    private Date createTime;

    private Date updateTime;
}
