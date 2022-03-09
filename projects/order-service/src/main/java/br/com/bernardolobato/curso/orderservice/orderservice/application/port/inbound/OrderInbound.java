package br.com.bernardolobato.curso.orderservice.orderservice.application.port.inbound;

import br.com.bernardolobato.curso.orderservice.orderservice.application.domain.Order;
import br.com.bernardolobato.curso.orderservice.orderservice.application.domain.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderInbound {
    UUID createOrder(List<Product> products);
    void addProduct(UUID id, Product product);
    void completeOrder(UUID id);
    void deleteProduct(UUID id, UUID productId);
    Optional<Order> findById(UUID id);
}