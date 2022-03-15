package com.br.paymentservice.application.service;

import com.br.paymentservice.application.domain.Payment;
import com.br.paymentservice.application.domain.PaymentStatus;
import com.br.paymentservice.application.port.inbound.PaymentInbound;
import com.br.paymentservice.application.port.outbound.PaymentEventPublisher;
import com.br.paymentservice.application.port.outbound.PaymentRepository;

import java.util.UUID;

public class PaymentDomainService implements PaymentInbound {

    private final PaymentEventPublisher paymentEventPublisher;
    private final PaymentRepository paymentRepository;

    public PaymentDomainService(PaymentEventPublisher paymentEventPublisher, PaymentRepository paymentRepository) {
        this.paymentEventPublisher = paymentEventPublisher;
        this.paymentRepository = paymentRepository;
    }


    @Override
    public void paymentApproved(String orderEventId) {
       Payment payment = new Payment(UUID.randomUUID().toString(), PaymentStatus.APPROVED, orderEventId);
       paymentRepository.save(payment);
    }
}
