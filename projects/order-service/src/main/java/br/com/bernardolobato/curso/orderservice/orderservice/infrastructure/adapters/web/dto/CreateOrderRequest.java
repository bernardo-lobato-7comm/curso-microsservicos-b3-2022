package br.com.bernardolobato.curso.orderservice.orderservice.infrastructure.adapters.web.dto;

import br.com.bernardolobato.curso.orderservice.orderservice.application.domain.Product;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CreateOrderRequest {
    private List<Product> products;

    @JsonCreator
    public CreateOrderRequest(@JsonProperty("products") final List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}