package br.com.bernardolobato.curso.orderservice.orderservice.application.port.outbound;

import br.com.bernardolobato.curso.orderservice.orderservice.application.events.DomainEvent;

import java.util.List;

public interface OrderEventPublisher {
    void publish(List<DomainEvent> events);
}
