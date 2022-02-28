package com.example.hexagonalarchitecture.adapters.persistence;

import com.example.hexagonalarchitecture.application.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringDataProductRepository extends MongoRepository<Product, String> {
}
