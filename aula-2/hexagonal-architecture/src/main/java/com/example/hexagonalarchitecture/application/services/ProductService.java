package com.example.hexagonalarchitecture.application.services;

import com.example.hexagonalarchitecture.application.domain.Product;
import com.example.hexagonalarchitecture.application.port.incoming.UpdateProduct;
import com.example.hexagonalarchitecture.application.port.outgoing.LoadProductPort;
import com.example.hexagonalarchitecture.application.port.outgoing.SaveProductPort;

import java.util.NoSuchElementException;

public class ProductService implements UpdateProduct {

    private LoadProductPort loadProductPort;
    private SaveProductPort saveProductPort;

    public ProductService(LoadProductPort loadProductPort, SaveProductPort saveProductPort) {
        this.loadProductPort = loadProductPort;
        this.saveProductPort = saveProductPort;
    }

    @Override
    public void update(String id, Double price) {
        Product product = loadProductPort.load(id).orElseThrow(NoSuchElementException::new);
        product.setPrice(price);
        saveProductPort.save(product);
    }
}
