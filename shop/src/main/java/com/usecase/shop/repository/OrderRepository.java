package com.usecase.shop.repository;

import com.usecase.shop.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, String> {


    @Override
    List<Order> findAll();

}

