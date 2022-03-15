package com.br.userservice.infrastructure.adapters.repository;

import com.br.userservice.application.domain.User;
import com.br.userservice.application.port.outbound.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class UserMongoRepository implements UserRepository {

    private SpringDataMongoUserRepository springDataMongoUserRepository;


    public UserMongoRepository(SpringDataMongoUserRepository repository) {
        this.springDataMongoUserRepository = repository;
    }

    @Override
    public Optional<User> findById(UUID id) {
        return springDataMongoUserRepository.findById(id);
    }

    @Override
    public void save(User user) {
        springDataMongoUserRepository.save(user);
    }
}
