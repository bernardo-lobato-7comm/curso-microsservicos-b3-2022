package br.com.bernardolobato.curso.orderservice.orderservice.application.events;

import java.util.UUID;

public class OrderCompletedEvent  extends DomainEvent {
    private final UUID orderID;

    public OrderCompletedEvent(UUID orderID) {
        super();
        this.orderID = orderID;
    }
}
