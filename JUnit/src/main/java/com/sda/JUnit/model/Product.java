package com.sda.JUnit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productName;
    private String description;
    private String productCategory;

    public Product(int id, String productName, String description, String productCategory) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.productCategory = productCategory;
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public Product setId(int id) {
        this.id = id;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public Product setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public Product setProductCategory(String productCategory) {
        this.productCategory = productCategory;
        return this;
    }

}
