package com.example.hexagonalarchitecture.adapters.persistence;

import com.example.hexagonalarchitecture.application.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataProductRepository extends JpaRepository<Product, Long> {
}
