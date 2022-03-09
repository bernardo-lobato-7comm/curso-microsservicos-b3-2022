package br.com.bernardolobato.curso.orderservice.orderservice.infrastructure.adapters.repository;

import br.com.bernardolobato.curso.orderservice.orderservice.application.domain.Order;
import br.com.bernardolobato.curso.orderservice.orderservice.application.port.outbound.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Optional;
import java.util.UUID;

@Component
public class OrderMongoRepository implements OrderRepository {
    private SpringDataMongoOrderRepository springDataMongoOrderRepository;

    @Autowired
    public OrderMongoRepository(SpringDataMongoOrderRepository springDataMongoOrderRepository) {
        this.springDataMongoOrderRepository = springDataMongoOrderRepository;
    }

    @Override
    public Optional<Order> findById(final UUID id) {
        return springDataMongoOrderRepository.findById(id);
    }

    @Override
    public void save(final Order order) {
        springDataMongoOrderRepository.save(order);
    }
}
