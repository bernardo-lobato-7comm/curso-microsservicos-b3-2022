package br.com.bernardolobato.curso.orderservice.orderservice.infrastructure.configuration;

import br.com.bernardolobato.curso.orderservice.orderservice.OrderServiceApplication;
import br.com.bernardolobato.curso.orderservice.orderservice.application.port.outbound.OrderEventPublisher;
import br.com.bernardolobato.curso.orderservice.orderservice.application.port.outbound.OrderRepository;
import br.com.bernardolobato.curso.orderservice.orderservice.application.service.OrderDomainService;
import br.com.bernardolobato.curso.orderservice.orderservice.application.port.inbound.OrderInbound;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = OrderServiceApplication.class)
public class BeanConfiguration {

    @Bean
    OrderInbound orderService(final OrderRepository orderRepository, final OrderEventPublisher publisher) {
        return new OrderDomainService(orderRepository, publisher);
    }
}
