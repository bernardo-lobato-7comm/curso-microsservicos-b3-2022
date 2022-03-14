package com.br.paymentservice.infrastructure.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class KafkaMessageProducer {

    private static KafkaTemplate<String, String> kafkaTemplate;

    private static final String paymentTopic = "PaymentService";


    @Autowired
    public KafkaMessageProducer(KafkaTemplate<String, String> kafkaTemplate) {
        KafkaMessageProducer.kafkaTemplate = kafkaTemplate;
    }

    public static void publish(String message) throws IOException {
        log.info("Pedido -> {}, Approved", message);
        kafkaTemplate.send(paymentTopic, message);
    }
}
