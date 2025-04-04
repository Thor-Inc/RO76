package com.usecase.shop.form;

import com.usecase.shop.entities.Product;
import org.springframework.web.multipart.MultipartFile;

public class ProductForm {
        private String code;
        private String name;
        private double price;

        private boolean newProduct = false;

        // Upload file.
        private MultipartFile fileData;

        public ProductForm() {
            this.newProduct= true;
        }

        public ProductForm(Product product) {
            this.code = product.getCode();
            this.name = product.getName();
            this.price = product.getPrice();
        }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public MultipartFile getFileData() {
            return fileData;
        }

        public void setFileData(MultipartFile fileData) {
            this.fileData = fileData;
        }

        public boolean isNewProduct() {
            return newProduct;
        }

        public void setNewProduct(boolean newProduct) {
            this.newProduct = newProduct;
        }

    }