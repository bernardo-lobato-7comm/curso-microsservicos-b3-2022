package com.br.userservice.application.port.outbound;

import com.br.userservice.application.domain.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<User>findById(UUID id);
    void save(User user);
}
