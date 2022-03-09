package br.com.bernardolobato.curso.productservice.infrastructure;

import br.com.bernardolobato.curso.productservice.dto.BookingDTO;
import br.com.bernardolobato.curso.productservice.dto.ProductDTO;
import br.com.bernardolobato.curso.productservice.entities.Booking;
import br.com.bernardolobato.curso.productservice.entities.Product;
import br.com.bernardolobato.curso.productservice.repository.BookingRepository;
import br.com.bernardolobato.curso.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductTransactionScript {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    BookingRepository bookingRepository;

    @PostMapping("/")
    public Product save(@RequestBody ProductDTO dto) {
        Product p = Product.builder()
                        .name(dto.getName())
                        .brand(dto.getBrand())
                        .description(dto.getDescription())
                        .build();
        this.productRepository.save(p);
        return p;
    }
    @PutMapping("/{id}")
    public Product edit(@RequestBody ProductDTO dto, @RequestParam UUID id) {
        Product p = this.productRepository.findById(id).get();
        p.setBrand(dto.getBrand());
        p.setDescription(dto.getDescription());
        p.setName(dto.getName());
        this.productRepository.save(p);
        return p;
    }
    @DeleteMapping("/{id}")
    public void delete(@RequestParam UUID id) {
        this.productRepository.deleteById(id);
    }

    @PostMapping("/bookProduct")
    public void book(@RequestBody BookingDTO dto) {
        Product p = this.productRepository.findById(UUID.fromString(dto.getProductId()))
                .orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto não encontrado"));

        if (p.getQuantity() < dto.getQuantity()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quantidade indisponível");
        }

        List<Booking> bookings = this.bookingRepository.findAllByProductId(dto.getProductId());
        Integer total = bookings.stream().mapToInt((booking)->booking.getQuantity()).sum();

        if (p.getQuantity() < total) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quantidade indisponível");
        }
        Booking b = Booking.builder().product(p).transactionId(dto.getTransactionId()).quantity(dto.getQuantity()).build();
        bookingRepository.save(b);
    }

    @PostMapping("/retrieve")
    public void retrieve(@RequestParam String transactionId) {
        this.bookingRepository.deleteById(UUID.fromString(transactionId));
        //TODO: Add soft delete by status
        //TODO add Domain Events
        //TODO update versioning
    }

    @PostMapping("/confirm")
    public void confirm(@RequestParam String transactionId) {
        Booking booking = this.bookingRepository.findById(UUID.fromString(transactionId)).get();
        Product p = this.productRepository.findById(booking.getProduct().getId()).get();
        p.setQuantity(p.getQuantity() - booking.getQuantity());
        productRepository.save(p);
        bookingRepository.delete(booking);
        //TODO: Add soft delete by status
        //TODO add Domain Events
        //TODO update versioning
    }
}
