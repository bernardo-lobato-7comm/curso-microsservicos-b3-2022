package br.com.bernardolobato.curso.orderservice.orderservice.infrastructure.configuration;

import br.com.bernardolobato.curso.orderservice.orderservice.infrastructure.adapters.repository.OrderMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = OrderMongoRepository.class)
public class MongoDBConfiguration {
}
