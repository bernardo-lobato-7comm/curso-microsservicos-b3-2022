package br.com.bernardolobato.curso.productservice.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
public class Product {
    @Id
    UUID id;
    String name;
    String brand;
    String description;
    Integer quantity;
}
