package pl.sdacademy.java.spring.advanced.workshop5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("prod")
//@ConditionalOnProperty({"app.foo.x","app.foo.text"})
@ConditionalOnProperty("app.foo.text")
@Component
public class FooImpl implements Foo {
    private final int x;
    private final String text;

    public FooImpl(
            @Value("${app.foo.x}") int x,
            @Value("${app.foo.text}") String text
    ) {
        this.x = x;
        this.text = text;
    }

    @Override
    public String getMessage() {
        return "Implementacja produkcyjna: " + x + ", " + text;
    }
}
