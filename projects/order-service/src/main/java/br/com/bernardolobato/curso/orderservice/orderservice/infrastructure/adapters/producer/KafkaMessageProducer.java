package br.com.bernardolobato.curso.orderservice.orderservice.infrastructure.adapters.producer;

import br.com.bernardolobato.curso.orderservice.orderservice.application.events.DomainEvent;
import br.com.bernardolobato.curso.orderservice.orderservice.application.port.outbound.OrderEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class KafkaMessageProducer implements OrderEventPublisher {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaMessageProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach((event)-> {
            this.kafkaTemplate.send(event.getClass().getSimpleName(), event.getId().toString(), event.toString());
            log.info(String.format("Produced user -> %s", event));
        });
    }
}