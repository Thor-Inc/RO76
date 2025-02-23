/*
package com.sda.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    // Is there something invalid?
    @GetMapping("/getData/{id}")
    public String get(@PathVariable(name = "id") final Integer id,
                           ModelMap orderMap) {
        // .. do something .. call repo, get product
        return "products";
    }

    // ============= DONE

    // what is the URL ?
    @GetMapping("/{id}")
    public String getProduct(@PathVariable(name = "id") final Integer id,
                             ModelMap productMap) {
        // .. do something .. call repo, get product
        return "products";
    }

    // what is the URL ?
    @PostMapping("/search")
    public String searchProducts(@RequestParam(name = "criteria") final String criteria,
                                 ModelMap productMap) {
        // .. do something .. call repo, get product
        return "products";
    }

    // what is the URL ?
    @PostMapping("/multiFilter")
    public String filterProducts(@RequestParam(name = "name") final String name,
                                 @RequestParam(name = "price") final String price,
                                 @RequestParam(name = "model") final String model,
                                 ModelMap productMap) {
        // .. do something .. call repo, get product
        return "products";
    }

    // what is the URL ?
    @RequestMapping(value = "/api/messages/{index}", method = RequestMethod.PUT)
    public void updateMessage(@RequestBody final String message, @PathVariable final Integer index) {
        // do update
    }

    // Is there something invalid?
    @GetMapping("/{id}")
    public String getProductInvalid(@PathVariable(name = "id") final Integer id,
                                    ModelMap orderMap) {
        // .. do something .. call repo, get product
        return "products";
    }
}
*/
