package com.br.userservice.application.events;


import java.util.UUID;

public class UserCreatedEvent extends DomainEvent {
    private String userId;

    public UserCreatedEvent(String userId) {
        super();
        this.userId = userId;
    }
}
