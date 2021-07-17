package pl.sdacademy.java.spring.hellotemplates.homework;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class ProductsService {
    private final AtomicInteger atomicInteger = new AtomicInteger();
    private final Map<Integer, Product> map = new ConcurrentHashMap<>();

    public List<Product> getProducts() {
        return map.values().stream()
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());
    }

    public Optional<Product> getProduct(int id) {
        return Optional.ofNullable(map.get(id));
    }

    public void addProduct(Product product) {
        //Użycie AtomicInteger gwarantuje bezpieczną wątkowo inkrementację
        final int index = atomicInteger.incrementAndGet();
        product.setId(index);
        map.put(index, product);
    }
}
