package br.com.bernardolobato.curso.orderservice.orderservice.application.events;

import java.util.UUID;

public class OrderCreatedEvent  extends DomainEvent {
    private final UUID orderID;

    public OrderCreatedEvent(UUID orderID) {
        super();
        this.orderID = orderID;
    }
}
