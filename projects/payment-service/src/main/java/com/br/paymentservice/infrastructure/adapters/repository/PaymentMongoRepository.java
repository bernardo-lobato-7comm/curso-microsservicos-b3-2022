package com.br.paymentservice.infrastructure.adapters.repository;

import com.br.paymentservice.application.domain.Payment;
import com.br.paymentservice.application.port.outbound.PaymentRepository;
import org.springframework.stereotype.Component;

@Component
public class PaymentMongoRepository implements PaymentRepository {

    private SpringDataMongoPaymentRepository springDataMongoPaymentRepository;

    public PaymentMongoRepository(SpringDataMongoPaymentRepository springDataMongoPaymentRepository) {
        this.springDataMongoPaymentRepository = springDataMongoPaymentRepository;
    }


    @Override
    public void save(Payment payment) {
        springDataMongoPaymentRepository.save(payment);
    }
}
