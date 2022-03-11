package com.br.userservice.application.port.outbound;

import com.br.userservice.application.events.DomainEvent;

import java.util.List;

public interface UserEventPublisher {
    void publish(List<DomainEvent> events);
}
