package br.com.bernardolobato.curso.orderservice.orderservice.application.service;

import br.com.bernardolobato.curso.orderservice.orderservice.application.domain.Order;
import br.com.bernardolobato.curso.orderservice.orderservice.application.domain.Product;
import br.com.bernardolobato.curso.orderservice.orderservice.application.port.inbound.OrderInbound;
import br.com.bernardolobato.curso.orderservice.orderservice.application.port.outbound.OrderEventPublisher;
import br.com.bernardolobato.curso.orderservice.orderservice.application.port.outbound.OrderRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OrderDomainService implements OrderInbound {

    private final OrderRepository orderRepository;
    private final OrderEventPublisher orderEventPublisher;

    public OrderDomainService(final OrderRepository orderRepository, OrderEventPublisher orderEventPublisher) {
        this.orderRepository = orderRepository;
        this.orderEventPublisher = orderEventPublisher;
    }

    @Override
    public UUID createOrder(final List<Product> products) {
        final Order order = new Order(UUID.randomUUID(), products);
        orderRepository.save(order);
        orderEventPublisher.publish(order.getEvents());
        order.clearEvents();
        return order.getId();
    }

    @Override
    public void addProduct(final UUID id, final Product product) {
        final Order order = findById(id).get();
        order.addProduct(product);

        orderEventPublisher.publish(order.getEvents());
        order.clearEvents();
        orderRepository.save(order);
    }

    @Override
    public void completeOrder(final UUID id) {
        final Order order = findById(id).get();
        order.complete();

        orderEventPublisher.publish(order.getEvents());
        order.clearEvents();
        orderRepository.save(order);
    }

    @Override
    public void deleteProduct(final UUID id, final UUID productId) {
        final Order order = findById(id).get();
        order.removeProduct(productId);
        orderEventPublisher.publish(order.getEvents());
        order.clearEvents();
        orderRepository.save(order);
    }
    @Override
    public Optional<Order> findById(UUID id) {
        return orderRepository.findById(id);
    }
}
