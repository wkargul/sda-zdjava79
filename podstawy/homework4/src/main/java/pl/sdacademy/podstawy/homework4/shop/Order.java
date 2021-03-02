package pl.sdacademy.podstawy.homework4.shop;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.ZonedDateTime;

public class Order {
    private final Product product;
    private final int quantity;
    private final String customerName;
    private final BigDecimal totalPrice;
    private final ZonedDateTime creationTime;

    static Order create(Product product, int quantity, String customerName, Clock clock) {
        final BigDecimal totalPrice = product.getPrice().multiply(BigDecimal.valueOf(quantity));
        final ZonedDateTime now = ZonedDateTime.now(clock);
        return new Order(product, quantity, customerName, totalPrice, now);
    }

    private Order(
            Product product,
            int quantity,
            String customerName,
            BigDecimal totalPrice,
            ZonedDateTime creationTime
    ) {
        this.product = product;
        this.quantity = quantity;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
        this.creationTime = creationTime;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCustomerName() {
        return customerName;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public ZonedDateTime getCreationTime() {
        return creationTime;
    }

    public String toString() {
        return String.format(
                "%s: %s (value: %s); %s [%d]",
                creationTime, customerName, totalPrice, product.getName(), quantity
        );
    }
}
