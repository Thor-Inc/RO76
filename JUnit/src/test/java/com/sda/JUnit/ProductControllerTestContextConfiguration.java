package com.sda.JUnit;

import com.sda.JUnit.repository.ProductRepository;
import com.sda.JUnit.service.ProductService;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import javax.sql.DataSource;

@TestConfiguration
public class ProductControllerTestContextConfiguration {

    @Bean
    public ProductService productService() {
        return new ProductService(productRepository) {
            // implement methods
        };
    }


    @MockitoBean
    private ProductRepository productRepository;

}
