package pl.sdacademy.java.spring.advanced.workshop4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FooImpl implements Foo {
    private final int x;
    private final String y;

    public FooImpl(
            @Value("${app.foo.x}") int x,
            @Value("${app.foo.y}") String y
    ) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String getMessage() {
        return "Implementacja produkcyjna: " + x + ", " + y;
    }
}
