package com.br.paymentservice.infrastructure.configuration;

import com.br.paymentservice.PaymentServiceApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = PaymentServiceApplication.class)
public class BeanConfiguration {

    //@Bean
    //PaymentInbound paymentService(PaymentEventPublisher paymentEventPublisher){
    //}
}
