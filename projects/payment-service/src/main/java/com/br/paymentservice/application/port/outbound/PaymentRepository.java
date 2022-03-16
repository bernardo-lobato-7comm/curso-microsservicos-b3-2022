package com.br.paymentservice.application.port.outbound;

import com.br.paymentservice.application.domain.Payment;

public interface PaymentRepository {
    void save(Payment payment);
}
