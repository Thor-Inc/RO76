package com.sda.JUnit.repository;

import com.sda.JUnit.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product getProductById(int id);
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Product p SET p.productName = :#{#product.productName}, " +
                  "p.productCategory = :#{#product.productCategory}, p.description = :#{#product.description} " +
                  "WHERE p.id = :#{#product.id}")
    void updateProduct(@Param("product") Product product);
}
