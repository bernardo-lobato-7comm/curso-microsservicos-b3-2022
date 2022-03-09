package br.com.bernardolobato.curso.productservice.repository;

import br.com.bernardolobato.curso.productservice.entities.Booking;
import br.com.bernardolobato.curso.productservice.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface BookingRepository  extends CrudRepository<Booking, UUID> {
    List<Booking> findAllByProductId(String productID);
}
