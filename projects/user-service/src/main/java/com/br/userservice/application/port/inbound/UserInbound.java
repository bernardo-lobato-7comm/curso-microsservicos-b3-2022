package com.br.userservice.application.port.inbound;

import com.br.userservice.application.domain.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserInbound {
    String createUser(String email);
    void deleteUser(String id);
    Optional<User> findById(String id);
    List<User> findAll();
}
