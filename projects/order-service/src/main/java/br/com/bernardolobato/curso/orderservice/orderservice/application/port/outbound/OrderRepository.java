package br.com.bernardolobato.curso.orderservice.orderservice.application.port.outbound;

import br.com.bernardolobato.curso.orderservice.orderservice.application.domain.Order;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {
    Optional<Order> findById(UUID id);
    void save(Order order);
}
