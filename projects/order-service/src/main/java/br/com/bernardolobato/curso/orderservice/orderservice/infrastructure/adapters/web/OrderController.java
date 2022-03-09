package br.com.bernardolobato.curso.orderservice.orderservice.infrastructure.adapters.web;

import br.com.bernardolobato.curso.orderservice.orderservice.application.domain.Order;
import br.com.bernardolobato.curso.orderservice.orderservice.application.port.inbound.OrderInbound;
import br.com.bernardolobato.curso.orderservice.orderservice.infrastructure.adapters.web.dto.AddProductRequest;
import br.com.bernardolobato.curso.orderservice.orderservice.infrastructure.adapters.web.dto.CreateOrderRequest;
import br.com.bernardolobato.curso.orderservice.orderservice.infrastructure.adapters.web.dto.CreateOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderInbound orderInbound;

    @Autowired
    public OrderController(OrderInbound orderInbound) {
        this.orderInbound = orderInbound;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    CreateOrderResponse createOrder(@RequestBody final CreateOrderRequest createOrderRequest) {
        final UUID id = orderInbound.createOrder(createOrderRequest.getProducts());

        return new CreateOrderResponse(id);
    }

    @GetMapping("/{id}")
    Order findById(@PathVariable final UUID id) {
        final Order o = orderInbound.findById(id).get();

        return o;
    }

    @PostMapping(value = "/{id}/products", consumes = MediaType.APPLICATION_JSON_VALUE)
    void addProduct(@PathVariable final UUID id, @RequestBody final AddProductRequest addProductRequest) {
        orderInbound.addProduct(id, addProductRequest.getProduct());
    }

    @DeleteMapping(value = "/{id}/products", consumes = MediaType.APPLICATION_JSON_VALUE)
    void deleteProduct(@PathVariable final UUID id, @RequestParam final UUID productId) {
        orderInbound.deleteProduct(id, productId);
    }

    @PostMapping("/{id}/complete")
    void completeOrder(@PathVariable final UUID id) {
        orderInbound.completeOrder(id);
    }
}
