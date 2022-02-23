package com.example.hexagonalarchitecture.application.port.outgoing;

import com.example.hexagonalarchitecture.application.domain.Product;

import java.util.Optional;

public interface LoadProductPort {
    Optional<Product> load(Long id);
}
