package com.br.userservice.application.service;

import com.br.userservice.application.domain.User;
import com.br.userservice.application.events.UserCreatedEvent;
import com.br.userservice.application.exceptions.DomainException;
import com.br.userservice.application.port.inbound.UserInbound;
import com.br.userservice.application.port.outbound.UserEventPublisher;
import com.br.userservice.application.port.outbound.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserDomainService implements UserInbound {

    private final UserRepository userRepository;
    private final UserEventPublisher userEventPublisher;

    public UserDomainService(final UserRepository userRepository, final UserEventPublisher userEventPublisher) {
        this.userRepository = userRepository;
        this.userEventPublisher = userEventPublisher;
    }

    @Override
    public String createUser(String email) {
        User user = new User(UUID.randomUUID().toString(), email);
        userRepository.save(user);
        userEventPublisher.publish(user.getEvents());
        user.clearEvents();
        return user.getId();
    }

    @Override
    public void deleteUser(String id) {
        Optional<User> obj = findById(id);
        User user = obj.orElseThrow(() -> new DomainException("Usuário não existe"));
        user.getEvents().add(new UserCreatedEvent(user.getId()));
        deleteUser(id);
        userEventPublisher.publish(user.getEvents());
        user.clearEvents();
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
