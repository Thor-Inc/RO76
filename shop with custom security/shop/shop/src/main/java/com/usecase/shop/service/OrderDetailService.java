package com.usecase.shop.service;

import com.usecase.shop.entities.Order;
import com.usecase.shop.entities.OrderDetail;
import com.usecase.shop.model.OrderDetailInfo;
import com.usecase.shop.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {

    @Autowired
    private final OrderDetailRepository orderDetailRepository;


    public OrderDetailService(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }


    public void addOrderDetail(OrderDetail detail) {
        orderDetailRepository.save(detail);
    }

    public OrderDetailInfo findOrderDetailInfoById(String orderDetailId) {
        OrderDetailInfo orderDetailInfo = new OrderDetailInfo();

        Optional<OrderDetail> orderDetail = orderDetailRepository.findById(orderDetailId);

        if(orderDetail.isPresent()) {
            orderDetailInfo = new OrderDetailInfo(orderDetail.get());
        }

        return orderDetailInfo;
    }

    public Optional<List<OrderDetail>> findOrderDetailInfoByOrder(Order order) {
        return orderDetailRepository.findByOrder(order);
    }
}
