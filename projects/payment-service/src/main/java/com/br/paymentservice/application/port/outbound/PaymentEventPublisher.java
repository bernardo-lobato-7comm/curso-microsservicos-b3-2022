package com.br.paymentservice.application.port.outbound;

import com.br.paymentservice.application.events.PaymentCreatedEvent;

public interface PaymentEventPublisher {
    void publish(PaymentCreatedEvent paymentCreatedEvent);
}
