package com.hgp.sell.service.impl;

import com.hgp.sell.converter.OrderMasterToOrderDTOConverter;
import com.hgp.sell.dataobject.OrderDetail;
import com.hgp.sell.dataobject.OrderMaster;
import com.hgp.sell.dataobject.ProductInfo;
import com.hgp.sell.dto.CartDTO;
import com.hgp.sell.dto.OrderDTO;
import com.hgp.sell.enums.ResultEnum;
import com.hgp.sell.exception.SellException;
import com.hgp.sell.repository.OrderDetailRepository;
import com.hgp.sell.repository.OrderMasterRepository;
import com.hgp.sell.service.OrderService;
import com.hgp.sell.service.ProductInfoService;
import com.hgp.sell.util.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @Author: GuangPeng He
 * @Date: 2020/11/28 0:48
 * @Remark AoLiGei
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId = KeyUtil.getUniqueKey();
        AtomicReference<BigDecimal> orderAmount = new AtomicReference<>(new BigDecimal(BigInteger.ZERO));

        // 查询商品信息
        orderDTO.getOrderDetailList().forEach(orderDetail -> {
            ProductInfo productInfo = productInfoService.findOne(orderDetail.getProductId());
            if (productInfo == null)
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);

            // 校验总价
            orderAmount.set(productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmount.get()));

            // 订单详情入库
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetail.setProductQuantity(orderDetail.getProductQuantity());
            orderDetail.setDetailId(KeyUtil.getUniqueKey());
            orderDetail.setOrderId(orderId);
            orderDetailRepository.save(orderDetail);
        });

        // 主订单入库
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster,"orderStatus","payStatus");
        orderMaster.setOrderAmount(orderAmount.get());
        orderMaster.setOrderId(orderId);
        orderMasterRepository.save(orderMaster);

        // 下单成功 减库存
        List<CartDTO>  cartDTOList = orderDTO.getOrderDetailList().stream().map(
                e -> new CartDTO(e.getProductId(), e.getProductQuantity())
        ).collect(Collectors.toList());
        productInfoService.decreaseStock(cartDTOList);
        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        OrderDTO orderDTO = new OrderDTO();
        // 获取主订单数据
        Optional<OrderMaster> orderMasterOptional = orderMasterRepository.findById(orderId);
        if(!orderMasterOptional.isPresent())
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);

        OrderMaster orderMaster = orderMasterOptional.get();
        if(orderMaster == null)
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);

        BeanUtils.copyProperties(orderMaster,orderDTO);

        // 获取订单详情数据
        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderId);

        if(CollectionUtils.isEmpty(orderDetailList))
            throw new SellException(ResultEnum.ORDER_DETAIL_NOT_EXIST);

        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findPage(String buyerOpenid, Pageable pageable) {
        Page<OrderMaster> orderMasterRepositoryByBuyerOpenid = orderMasterRepository.findByBuyerOpenid(buyerOpenid
                , pageable);
        return new PageImpl<>(OrderMasterToOrderDTOConverter.convert(orderMasterRepositoryByBuyerOpenid
                .getContent()),pageable,orderMasterRepositoryByBuyerOpenid.getTotalElements());
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
