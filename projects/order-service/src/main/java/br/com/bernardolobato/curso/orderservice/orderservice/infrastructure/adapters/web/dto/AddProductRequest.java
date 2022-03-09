package br.com.bernardolobato.curso.orderservice.orderservice.infrastructure.adapters.web.dto;

import br.com.bernardolobato.curso.orderservice.orderservice.application.domain.Product;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddProductRequest {
    private Product product;

    @JsonCreator
    public AddProductRequest(@JsonProperty("product") final Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}
