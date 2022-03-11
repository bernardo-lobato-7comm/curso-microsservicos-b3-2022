package com.br.paymentservice.application.events;

import java.util.UUID;

public class PaymentCreatedEvent extends DomainEvent{
    private final UUID paymentId;

    public PaymentCreatedEvent(UUID paymentId) {
        super();
        this.paymentId = paymentId;
    }
}
