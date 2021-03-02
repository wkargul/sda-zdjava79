package pl.sdacademy.podstawy.homework4.shop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.sdacademy.podstawy.test.TestUtils;

import java.math.BigDecimal;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {
    
    @Test
    @DisplayName("toString() should return all order data")
    void toStringShouldReturnOrderData() {
        //GIVEN
        final Product product = new Product("Test", BigDecimal.valueOf(5));

        //WHEN
        final Order order = Order.create(product, 2, "Klient", TestUtils.clockFixture(Instant.parse("2019-07-17T15:15:22Z")));
        final String orderString = order.toString();
        
        //THEN
        assertThat(orderString).isEqualTo("2019-07-17T15:15:22Z[UTC]: Klient (value: 10); Test [2]");
    }

    @Test
    @DisplayName("Order value should be immutable once calculated")
    void shouldHaveImmutableValue() {
        //GIVEN
        final Product product = new Product("Test", BigDecimal.valueOf(5));

        //WHEN
        final Order order = Order.create(product, 2, "Klient", TestUtils.clockFixture(Instant.parse("2019-07-17T15:15:22Z")));
        product.setPrice(BigDecimal.valueOf(6));

        //THEN
        assertThat(order).isNotNull();
        assertThat(order.getTotalPrice()).isEqualByComparingTo("10");
    }
}
