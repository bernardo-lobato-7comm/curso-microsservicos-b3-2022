package com.br.userservice.application.port.outbound;

import com.br.userservice.application.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User>findById(String id);
    void save(User user);
    List<User>findAll();
    void delete(String id);
}
