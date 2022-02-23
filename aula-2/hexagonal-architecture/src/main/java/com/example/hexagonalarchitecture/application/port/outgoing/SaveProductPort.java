package com.example.hexagonalarchitecture.application.port.outgoing;

import com.example.hexagonalarchitecture.application.domain.Product;

public interface SaveProductPort {
    void save(Product product);
}
