package com.sda.JUnit.controller;

import com.sda.JUnit.model.Product;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @GetMapping("hello")
    public String mvcUnitTest() {
        return "Hello, World";
    }

    @PostMapping("/validate")
    public String validateProduct(@RequestBody Product product) {
        if(product.getProductName().contains("test")) return "this is a test";
        // some bussiness logic
        return "no test";
    }

}
