package com.br.paymentservice.infrastructure.consumer;

import com.br.paymentservice.infrastructure.producer.KafkaMessageProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class KafkaConsumer {


    @KafkaListener(topics = "OrderCreatedEvent")
    public static void consumeOrder(String message) throws IOException {
        String result = "Pagamento confirmado do pedido " + message;
        KafkaMessageProducer.publish(result);
        log.info(String.format("#### -> Pedido aprovado -> %s", message));
    }
}
