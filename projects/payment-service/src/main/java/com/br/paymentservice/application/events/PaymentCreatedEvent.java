package com.br.paymentservice.application.events;


public class PaymentCreatedEvent extends DomainEvent {
    private final String paymentId;

    public PaymentCreatedEvent(String paymentId) {
        super();
        this.paymentId = paymentId;
    }
}
