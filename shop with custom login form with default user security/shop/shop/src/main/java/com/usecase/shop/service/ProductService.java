package com.usecase.shop.service;

import com.usecase.shop.entities.Product;
import com.usecase.shop.form.ProductForm;
import com.usecase.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Product findProductByCode(String code) {
        return productRepository.findProductByCode(code);
    }

    public void addProduct(ProductForm productForm) {
        productRepository.save(mapProduct(productForm));
    }

    private Product mapProduct(ProductForm productForm) {
        Product product = new Product();
        product.setCode(productForm.getCode());
        product.setCreateDate(new Date());
        product.setName(productForm.getName());
        product.setPrice(productForm.getPrice());

        return product;
    }
}
