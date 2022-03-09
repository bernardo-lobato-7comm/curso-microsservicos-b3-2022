package br.com.bernardolobato.curso.orderservice.orderservice.infrastructure.adapters.repository;

import br.com.bernardolobato.curso.orderservice.orderservice.application.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataMongoOrderRepository extends MongoRepository<Order, UUID> {
}
