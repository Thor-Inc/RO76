package com.usecase.shop.service;

import com.usecase.shop.entities.Order;
import com.usecase.shop.entities.OrderDetail;
import com.usecase.shop.model.OrderDetailInfo;
import com.usecase.shop.model.OrderInfo;
import com.usecase.shop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;


    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Page<Order> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    public OrderInfo findOrderInfoById(String orderInfoId) {
        OrderInfo orderDetailInfo = new OrderInfo();

        Optional<Order> orderInfo = orderRepository.findById(orderInfoId);

        if(orderInfo.isPresent()) {
            orderDetailInfo = new OrderInfo(orderInfo.get());
        }

        return orderDetailInfo;
    }

    public Order findOrderById(String orderId) {

        Optional<Order> orderInfo = orderRepository.findById(orderId);

        return orderInfo.orElse(null);

    }
}
