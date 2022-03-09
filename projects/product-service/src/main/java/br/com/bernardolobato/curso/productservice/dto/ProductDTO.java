package br.com.bernardolobato.curso.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
public class ProductDTO {
    String name;
    String brand;
    String description;
}