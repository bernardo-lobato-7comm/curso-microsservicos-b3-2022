package com.br.userservice.infrastructure.adapters.consumers;

import com.br.userservice.application.port.inbound.UserInbound;
import io.confluent.shaded.com.google.gson.Gson;
import org.apache.avro.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class OrderCreatedConsumer {

    class OrderCreatedEvent {
        private final UUID orderID;
        private final UUID userID;

        private BigDecimal price;

        public OrderCreatedEvent(UUID orderID, UUID userID, BigDecimal price) {
            super();
            this.orderID = orderID;
            this.price = price;
            this.userID = userID;
        }

        public String toString() {return new Gson().toJson(this);}

    }


    private final UserInbound userInbound;

    @Autowired
    public OrderCreatedConsumer(UserInbound userInbound) {
        this.userInbound = userInbound;
    }

    @KafkaListener(topics = "OrderCreatedEvent", groupId = "UserService")
    public void listen(String in) {
        System.out.println(in);
        OrderCreatedEvent e = new Gson().fromJson(in, OrderCreatedEvent.class);
        this.userInbound.validateUser(e.userID);
        //System.out.println(e.userID);
    }
}
