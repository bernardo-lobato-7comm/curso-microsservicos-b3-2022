package com.br.paymentservice.infrastructure.adapters.consumer;

import com.br.paymentservice.application.port.inbound.PaymentInbound;
import com.br.paymentservice.infrastructure.adapters.producer.KafkaMessageProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class KafkaConsumer {

    @Autowired
    private KafkaMessageProducer kafkaMessageProducer;

    @Autowired
    private PaymentInbound paymentInbound;


    @KafkaListener(topics = "OrderCreatedEvent")
    public void consumeOrder(String message) throws IOException {
        String result = message.substring(15, 51);
        paymentInbound.paymentApproved(result);
        kafkaMessageProducer.publish(result);
    }
}
