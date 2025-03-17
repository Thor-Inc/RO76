package com.usecase.shop.repository;

import com.usecase.shop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

    public Product findProductByCode(String code);
}
