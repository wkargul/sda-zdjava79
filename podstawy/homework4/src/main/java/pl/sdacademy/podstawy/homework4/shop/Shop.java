package pl.sdacademy.podstawy.homework4.shop;

import java.math.BigDecimal;
import java.time.Clock;
import java.util.Arrays;

public class Shop {
    private static final short CUSTOMER_NAME = 1;
    private static final short PRODUCT_NAME = 2;
    
    private final Order[] orders;
    private final Clock clock;
    private int nextOrderIndex = 0;
    
    public static Shop create(int capacity, Clock clock) {
        return new Shop(new Order[capacity], clock);
    }

    private Shop(Order[] orders, Clock clock) {
        this.orders = orders;
        this.clock = clock;
    }
    
    public Order placeOrder(Product product, int quantity, String customerName) {
        if (nextOrderIndex >= orders.length) {
            return null;
        }
        
        final Order order = Order.create(product, quantity, customerName, clock);
        orders[nextOrderIndex] = order;
        nextOrderIndex++;
        
        return order;
    }
    
    public BigDecimal getTotal() {
        BigDecimal sum = BigDecimal.ZERO;
        
        for (final Order order : orders) {
            if (order == null) {
                break;
            }
            
            sum = sum.add(order.getTotalPrice());
        }
        
        return sum;
    }
    
    public Order[] searchByClient(String query) {
        return search(query, CUSTOMER_NAME);
    }
    
    public Order[] searchByProduct(String query) {
        return search(query, PRODUCT_NAME);
    }
    
    private Order[] search(String query, short mode) {
        final Order[] result = new Order[orders.length];
        
        int count = 0;
        for (final Order order : orders) {
            if (order == null) {
                break;
            }
            
            boolean match = false;
            
            switch (mode) {
                case CUSTOMER_NAME: {
                    match = order.getCustomerName().contains(query);
                    break;
                }
                
                case PRODUCT_NAME: {
                    match = order.getProduct().getName().contains(query);
                    break;
                }
            }
            
            if (match) {
                result[count] = order;
                count++;
            }
        }
        
        return Arrays.copyOf(result, count);
    }
}
