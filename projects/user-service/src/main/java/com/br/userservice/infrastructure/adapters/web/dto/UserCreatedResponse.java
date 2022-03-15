package com.br.userservice.infrastructure.adapters.web.dto;

import java.util.UUID;

public class UserCreatedResponse {

    private final String id;

    public UserCreatedResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
