package com.br.paymentservice.infrastructure.configuration;

import com.br.paymentservice.PaymentServiceApplication;
import com.br.paymentservice.application.port.inbound.PaymentInbound;
import com.br.paymentservice.application.port.outbound.PaymentEventPublisher;
import com.br.paymentservice.application.port.outbound.PaymentRepository;
import com.br.paymentservice.application.service.PaymentDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = PaymentServiceApplication.class)
public class BeanConfiguration {

    @Bean
    PaymentInbound paymentService(PaymentEventPublisher paymentEventPublisher, PaymentRepository paymentRepository) {
        return new PaymentDomainService(paymentEventPublisher, paymentRepository);
    }
}
