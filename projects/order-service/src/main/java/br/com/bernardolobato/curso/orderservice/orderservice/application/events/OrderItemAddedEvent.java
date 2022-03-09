package br.com.bernardolobato.curso.orderservice.orderservice.application.events;

import java.util.UUID;

public class OrderItemAddedEvent extends DomainEvent {
    private final UUID orderID;

    public OrderItemAddedEvent(UUID orderID) {
        super();
        this.orderID = orderID;
    }
}
