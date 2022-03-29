package com.br.userservice.application.events;


import java.util.UUID;

public class UserValidatedEvent extends DomainEvent {
    private String userId;
    private Boolean valid;

    public UserValidatedEvent(String userId, Boolean valid) {
        super();
        this.userId = userId;
        this.valid = valid;
    }
}
