package com.br.paymentservice.infrastructure.adapters.producer;

import com.br.paymentservice.application.port.outbound.PaymentEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageProducer implements PaymentEventPublisher {

    private static KafkaTemplate<String, String> kafkaTemplate;

    private static final String paymentTopic = "PaymentService";


    @Autowired
    public KafkaMessageProducer(KafkaTemplate<String, String> kafkaTemplate) {
        KafkaMessageProducer.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publish(String event) {
        String result = "Payment Approved from eventId -> " + event;
        kafkaTemplate.send(paymentTopic, result);
        log.info(String.format("Payment Approved from eventId -> %s", event));
    }
}
