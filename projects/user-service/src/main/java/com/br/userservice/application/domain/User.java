package com.br.userservice.application.domain;

import com.br.userservice.application.events.DomainEvent;
import com.br.userservice.application.events.UserCreatedEvent;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Data
@Slf4j
public class User implements Serializable {


    private String id;
    private String email;
    @JsonIgnore
    private List<DomainEvent> events = new ArrayList<>();

    public User() {
    }

    public User(String userId, String email) {
        this.id = userId;
        this.email = email;
        this.events.add(new UserCreatedEvent(this.id));
    }

    public void clearEvents() {
        this.events.clear();
    }
}
