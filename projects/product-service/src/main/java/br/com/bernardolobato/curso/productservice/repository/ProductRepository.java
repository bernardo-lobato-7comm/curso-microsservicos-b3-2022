package br.com.bernardolobato.curso.productservice.repository;

import br.com.bernardolobato.curso.productservice.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, UUID> {
}
