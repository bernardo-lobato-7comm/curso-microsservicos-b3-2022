package com.example.hexagonalarchitecture.adapters.configuration;

import com.example.hexagonalarchitecture.HexagonalArchitectureApplication;
import com.example.hexagonalarchitecture.adapters.persistence.ProductRepository;
import com.example.hexagonalarchitecture.application.services.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = HexagonalArchitectureApplication.class)
public class BeanConfiguration {


    @Bean
    ProductService productService(ProductRepository repository) {
        return new ProductService(repository, repository);
    }
}
