package com.br.userservice.infrastructure.configuration;

import com.br.userservice.infrastructure.adapters.repository.UserMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = UserMongoRepository.class)
public class MongoDBConfiguration {
}
