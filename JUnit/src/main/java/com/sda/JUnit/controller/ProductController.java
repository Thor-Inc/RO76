package com.sda.JUnit.controller;

import com.sda.JUnit.model.Product;
import com.sda.JUnit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    private Product product = new Product();


    @GetMapping("")
    public String showProducts(final ModelMap modelMap) {

        modelMap.addAttribute("productList", productService.getProductList());
        modelMap.addAttribute("foundProduct", product);
        modelMap.addAttribute("product", product);
        return "product";
    }

    @PostMapping("")
    public String searchProductByID(@ModelAttribute("product") Product searchProduct) {
        int searchIndex = searchProduct.getId();

        if(searchIndex == 0 || searchIndex < productService.getProductList().size()) {
            product = productService.getByID(searchProduct.getId());
        } else {
            product = new Product();
        }

        return "redirect:/products";
    }

    @PostMapping("/updated")
    public String updateProduct(@ModelAttribute("foundProduct") Product searchProduct, final Errors errors) {
        if (errors.hasErrors()) {
            return "redirect:/products";
        }

        productService.updateProduct(searchProduct);
        return "redirect:/products";
    }
}
