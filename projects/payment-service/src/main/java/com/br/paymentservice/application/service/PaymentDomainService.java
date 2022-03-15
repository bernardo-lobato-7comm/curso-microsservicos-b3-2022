package com.br.paymentservice.application.service;

import com.br.paymentservice.application.port.inbound.PaymentInbound;
import com.br.paymentservice.application.port.outbound.PaymentEventPublisher;

import java.util.UUID;

public class PaymentDomainService implements PaymentInbound {

    private final PaymentEventPublisher paymentEventPublisher;

    public PaymentDomainService(PaymentEventPublisher paymentEventPublisher) {
        this.paymentEventPublisher = paymentEventPublisher;
    }


    @Override
    public String paymentApproved(UUID orderId) {
        return "Payment from order " + orderId + " approved";
    }
}
