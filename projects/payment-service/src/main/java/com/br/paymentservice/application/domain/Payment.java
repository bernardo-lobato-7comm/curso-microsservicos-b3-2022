package com.br.paymentservice.application.domain;

import com.br.paymentservice.application.events.DomainEvent;
import com.br.paymentservice.application.events.PaymentCreatedEvent;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Payment {

    private String id;
    private PaymentStatus paymentStatus;
    private String orderEventId;
    @JsonIgnore
    private List<DomainEvent> events = new ArrayList<>();

    public Payment() {
    }

    public Payment(String id, PaymentStatus paymentStatus, String orderEventId) {
        this.id = id;
        this.paymentStatus = paymentStatus;
        this.orderEventId = orderEventId;
        this.events.add(new PaymentCreatedEvent(this.id));
    }
}
