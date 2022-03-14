package com.br.userservice.application.domain;

import com.br.userservice.application.events.DomainEvent;
import com.br.userservice.application.events.UserCreatedEvent;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Data
@Slf4j
public class User implements Serializable {

    private UUID userId;
    private String email;
    private List<DomainEvent> events = new ArrayList<>();

    public User() {
    }

    public User(UUID userId, String email) {
        this.userId = userId;
        this.email = email;
        this.events.add(new UserCreatedEvent(this.userId));
    }

    public void clearEvents() {
        this.events.clear();
    }
}
