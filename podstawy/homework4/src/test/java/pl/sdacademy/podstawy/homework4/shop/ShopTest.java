package pl.sdacademy.podstawy.homework4.shop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.sdacademy.podstawy.test.TestUtils;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class ShopTest {
    
    @Test
    @DisplayName("Should place valid new order")
    void shouldCreateValidNewOrder() {
        //GIVEN
        final Shop shop = Shop.create(1, TestUtils.clockFixture(Instant.parse("2019-07-17T15:15:22Z")));
        final Product product = new Product("Test", BigDecimal.valueOf(5));
        
        //WHEN
        final Order order = shop.placeOrder(product, 2, "Klient");
        
        //THEN
        assertThat(order).isNotNull();
        assertThat(order.getProduct()).isSameAs(product);
        assertThat(order.getCreationTime()).isEqualTo(ZonedDateTime.of(LocalDateTime.of(2019,7,17,15,15,22), ZoneId.of("UTC")));
        assertThat(order.getQuantity()).isEqualTo(2);
        assertThat(order.getCustomerName()).isEqualTo("Klient");
        assertThat(order.getTotalPrice()).isEqualByComparingTo("10");
    }
    
    @Test
    @DisplayName("Should allow placing only a limited number of orders")
    void shouldAllowPlacingOnlyLimitedNumberOfOrders() {
        //GIVEN
        final Shop shop = Shop.create(3, TestUtils.clockFixture(Instant.parse("2019-07-17T15:15:22Z")));
        final Product product = new Product("Test", BigDecimal.valueOf(5));
        
        //WHEN
        final Order order1 = shop.placeOrder(product, 2, "Klient");
        final Order order2 = shop.placeOrder(product, 2, "Klient");
        final Order order3 = shop.placeOrder(product, 2, "Klient");
        final Order order4 = shop.placeOrder(product, 2, "Klient");
        
        //THEN
        assertThat(order1).isNotNull();
        assertThat(order2).isNotNull();
        assertThat(order3).isNotNull();
        assertThat(order4).isNull();
    }
    
    @Test
    @DisplayName("Should not place an order in shop without capacity")
    void shouldNotPlaceOrderIfNoCapacity() {
        //GIVEN
        final Shop shop = Shop.create(0, TestUtils.clockFixture(Instant.parse("2019-07-17T15:15:22Z")));
        final Product product = new Product("Test", BigDecimal.valueOf(5));
        
        //WHEN
        final Order order = shop.placeOrder(product, 2, "Klient");
        
        //THEN
        assertThat(order).isNull();
    }
    
    @Test
    @DisplayName("Should always calculate current total value of all orders")
    void shouldAlwaysCalculateTotalValueOfAllOrders() {
        //GIVEN
        final Shop shop = Shop.create(4, TestUtils.clockFixture(Instant.parse("2019-07-17T15:15:22Z")));
        final Product product1 = new Product("Test1", BigDecimal.valueOf(10));
        final Product product2 = new Product("Test2", BigDecimal.valueOf(1));
        
        //WHEN
        final BigDecimal total1 = shop.getTotal();
        
        shop.placeOrder(product1, 1, "Klient");
        shop.placeOrder(product1, 2, "Klient");
        shop.placeOrder(product2, 1, "Klient");
        
        final BigDecimal total2 = shop.getTotal();
        
        shop.placeOrder(product2, 2, "Klient");
        
        final BigDecimal total3 = shop.getTotal();
        
        //THEN
        assertThat(total1).isEqualByComparingTo("0");
        assertThat(total2).isEqualByComparingTo("31");
        assertThat(total3).isEqualByComparingTo("33");
    }
    
    @Test
    @DisplayName("Should exclude orders not placed from total value calculation")
    void shouldExcludeOrdersNotPlacedFromTotalValueCalculation() {
        //GIVEN
        final Shop shop = Shop.create(3, TestUtils.clockFixture(Instant.parse("2019-07-17T15:15:22Z")));
        final Product product1 = new Product("Test1", BigDecimal.valueOf(10));
        final Product product2 = new Product("Test2", BigDecimal.valueOf(1));
        
        //WHEN
        shop.placeOrder(product1, 1, "Klient");
        shop.placeOrder(product1, 2, "Klient");
        shop.placeOrder(product2, 1, "Klient");
        
        final BigDecimal total1 = shop.getTotal();
        
        shop.placeOrder(product2, 2, "Klient");
        
        final BigDecimal total2 = shop.getTotal();
        
        //THEN
        assertThat(total1).isEqualByComparingTo("31");
        assertThat(total2).isEqualByComparingTo("31");
    }
    
    @Test
    @DisplayName("Should find matching results when searching by customer name")
    void shouldFindResultsWhenSearchByCustomer() {
        //GIVEN
        final Shop shop = Shop.create(3, TestUtils.clockFixture(Instant.parse("2019-07-17T15:15:22Z")));
        final Product product = new Product("Test", BigDecimal.valueOf(5));

        //WHEN
        shop.placeOrder(product, 1, "Aaa");
        shop.placeOrder(product, 1, "aaA");
        shop.placeOrder(product, 1, "Bbb");
        shop.placeOrder(product, 1, "bbB");
        final Order[] result = shop.searchByClient("aa");

        //THEN
        assertThat(result).hasSize(2);
        assertThat(result[0].getCustomerName()).isEqualTo("Aaa");
        assertThat(result[1].getCustomerName()).isEqualTo("aaA");
    }
    
    @Test
    @DisplayName("Should NOT find any matching results when searching by customer name")
    void shouldNotFindResultsWhenSearchByCustomer() {
        //GIVEN
        final Shop shop = Shop.create(3, TestUtils.clockFixture(Instant.parse("2019-07-17T15:15:22Z")));
        final Product product = new Product("Test", BigDecimal.valueOf(5));

        //WHEN
        shop.placeOrder(product, 1, "Aaa");
        shop.placeOrder(product, 1, "aaA");
        shop.placeOrder(product, 1, "Bbb");
        shop.placeOrder(product, 1, "bbB");
        final Order[] result = shop.searchByClient("cc");

        //THEN
        assertThat(result).isEmpty();
    }
    
    @Test
    @DisplayName("Should find matching results when searching by product name")
    void shouldFindResultsWhenSearchByProduct() {
        //GIVEN
        final Shop shop = Shop.create(3, TestUtils.clockFixture(Instant.parse("2019-07-17T15:15:22Z")));
        final Product product1 = new Product("Aaa", BigDecimal.valueOf(5));
        final Product product2 = new Product("aaA", BigDecimal.valueOf(5));
        final Product product3 = new Product("Bbb", BigDecimal.valueOf(5));
        final Product product4 = new Product("bbB", BigDecimal.valueOf(5));

        //WHEN
        shop.placeOrder(product1, 1, "Klient");
        shop.placeOrder(product2, 1, "Klient");
        shop.placeOrder(product3, 1, "Klient");
        shop.placeOrder(product4, 1, "Klient");
        final Order[] result = shop.searchByProduct("aa");

        //THEN
        assertThat(result).hasSize(2);
        assertThat(result[0].getProduct().getName()).isEqualTo("Aaa");
        assertThat(result[1].getProduct().getName()).isEqualTo("aaA");
    }
    
    @Test
    @DisplayName("Should NOT find any matching results when searching by product name")
    void shouldNotFindResultsWhenSearchByProduct() {
        //GIVEN
        final Shop shop = Shop.create(3, TestUtils.clockFixture(Instant.parse("2019-07-17T15:15:22Z")));
        final Product product1 = new Product("Aaa", BigDecimal.valueOf(5));
        final Product product2 = new Product("aaA", BigDecimal.valueOf(5));
        final Product product3 = new Product("Bbb", BigDecimal.valueOf(5));
        final Product product4 = new Product("bbB", BigDecimal.valueOf(5));

        //WHEN
        shop.placeOrder(product1, 1, "Klient");
        shop.placeOrder(product2, 1, "Klient");
        shop.placeOrder(product3, 1, "Klient");
        shop.placeOrder(product4, 1, "Klient");
        final Order[] result = shop.searchByProduct("cc");

        //THEN
        assertThat(result).isEmpty();
    }
}
