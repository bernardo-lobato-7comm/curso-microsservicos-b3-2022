package com.example.hexagonalarchitecture.adapters.persistence;

import com.example.hexagonalarchitecture.application.domain.Product;
import com.example.hexagonalarchitecture.application.port.outgoing.LoadProductPort;
import com.example.hexagonalarchitecture.application.port.outgoing.SaveProductPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductRepository implements LoadProductPort, SaveProductPort {

   private SpringDataProductRepository repository;


    public ProductRepository(SpringDataProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Product> load(String id) {
        return repository.findById(id);
    }

    @Override
    public void save(Product product) {
         repository.save(product);
    }
}
