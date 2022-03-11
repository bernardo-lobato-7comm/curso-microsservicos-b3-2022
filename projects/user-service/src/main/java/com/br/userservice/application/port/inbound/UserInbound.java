package com.br.userservice.application.port.inbound;

import com.br.userservice.application.domain.User;

import java.util.Optional;
import java.util.UUID;

public interface UserInbound {
    UUID createUser(String email);
    void deleteUser(UUID id);
    Optional<User> findById(UUID id);
}
