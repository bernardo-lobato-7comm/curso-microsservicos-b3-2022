package com.br.userservice.infrastructure.adapters.repository;

import com.br.userservice.application.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataMongoUserRepository extends MongoRepository<User, UUID> {
}
