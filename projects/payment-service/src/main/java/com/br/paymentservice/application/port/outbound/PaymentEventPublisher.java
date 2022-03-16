package com.br.paymentservice.application.port.outbound;

public interface PaymentEventPublisher {
    void publish(String event);
}
