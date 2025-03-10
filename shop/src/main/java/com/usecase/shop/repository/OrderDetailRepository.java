package com.usecase.shop.repository;

import com.usecase.shop.entities.Order;
import com.usecase.shop.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
    Optional<List<OrderDetail>> findByOrder(Order order);
}
