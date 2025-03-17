package com.sda.JUnit.service;

import com.sda.JUnit.model.Product;
import com.sda.JUnit.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    public final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

   private List<Product> productList = new ArrayList<>();

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    public Product getByID(int id){
       return productRepository.getProductById(id);
    }

    public void updateProduct(Product product){
        productRepository.save(product);

    }
}
