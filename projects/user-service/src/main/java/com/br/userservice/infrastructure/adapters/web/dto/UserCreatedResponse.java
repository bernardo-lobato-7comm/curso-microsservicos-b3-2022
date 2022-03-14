package com.br.userservice.infrastructure.adapters.web.dto;

import java.util.UUID;

public class UserCreatedResponse {

    private final UUID id;

    public UserCreatedResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
