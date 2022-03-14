package com.br.userservice.infrastructure.adapters.web.dto;

public class UserCreatedRequest {

    private String email;

    public UserCreatedRequest() {
    }

    public UserCreatedRequest(String email) {
        this.email = email;
    }

    public String getEmail(){
        return email;
    }
}
