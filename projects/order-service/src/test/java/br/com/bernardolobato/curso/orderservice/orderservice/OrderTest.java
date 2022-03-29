package br.com.bernardolobato.curso.orderservice.orderservice;


import br.com.bernardolobato.curso.orderservice.orderservice.application.domain.Order;
import br.com.bernardolobato.curso.orderservice.orderservice.application.domain.OrderItem;
import br.com.bernardolobato.curso.orderservice.orderservice.application.domain.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.UUID;

@SpringBootTest
public class OrderTest {
    private Order orderToTest;
    private Product product;
    private Product product2;
    @Before
    public void setUp() {
//        this.orderToTest = new Order(UUID.randomUUID(),  new Product(UUID.randomUUID(), new BigDecimal(10), "testProduct"));
        this.product = new Product(UUID.randomUUID(), new BigDecimal(10), "testProduct");
        this.product2 = new Product(UUID.randomUUID(), new BigDecimal(15), "testProduct2");

    }

    @Test
    public void shouldCreateOrderWithOneProduct() {
        Order o = new Order(UUID.randomUUID(), this.product);
        Assert.assertEquals(1, o.getOrderItems().size());
    }

    @Test
    public void shouldAddOneProductAndUpdateListSize() {
        Order o = new Order(UUID.randomUUID(), this.product);
        o.addProduct(product2);
        Assert.assertEquals(2, o.getOrderItems().size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldThrowUnsupportedOperationExceptionWhenAddProductDirectInList() {
        Order o = new Order(UUID.randomUUID(), this.product);
        o.getOrderItems().add(new OrderItem(this.product2));
    }

    @Test
    public void shouldAddOneProductAndUpdatePrice() {
        Order o = new Order(UUID.randomUUID(), this.product);
        o.addProduct(product2);
        BigDecimal expected = new BigDecimal(25);

        Assert.assertEquals(expected, o.getPrice());
    }
}
