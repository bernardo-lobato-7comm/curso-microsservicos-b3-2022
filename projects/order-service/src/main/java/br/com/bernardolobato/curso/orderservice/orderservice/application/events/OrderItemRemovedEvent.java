package br.com.bernardolobato.curso.orderservice.orderservice.application.events;

import java.util.UUID;

public class OrderItemRemovedEvent extends DomainEvent {
    private final UUID orderID;

    public OrderItemRemovedEvent(UUID orderID) {
        super();
        this.orderID = orderID;
    }
}
