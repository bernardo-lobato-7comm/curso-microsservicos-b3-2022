package com.br.paymentservice.infrastructure.adapters.repository;

import com.br.paymentservice.application.domain.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataMongoPaymentRepository extends MongoRepository<Payment, String> {
}
