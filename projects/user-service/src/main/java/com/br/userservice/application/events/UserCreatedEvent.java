package com.br.userservice.application.events;


import java.util.UUID;

public class UserCreatedEvent extends DomainEvent{
    private final UUID userId;

    public UserCreatedEvent(UUID userId){
        super();
        this.userId = userId;
    }
}
