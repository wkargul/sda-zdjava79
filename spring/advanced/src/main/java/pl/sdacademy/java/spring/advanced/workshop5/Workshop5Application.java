package pl.sdacademy.java.spring.advanced.workshop5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class Workshop5Application {

    public static void main(String[] args) {
        SpringApplication.run(Workshop5Application.class, args);
    }

    @Bean
    @Profile("!prod")
    public Foo fooNonProd(
        @Value("${app.foo.x}") int x,
        @Value("${app.foo.y}") String y
    ) {
        return () -> "Implementacja nieprodukcyjna: " + x + " " + y;
    }

    @Bean
    @ConditionalOnMissingBean(Foo.class)
    public Foo fallbackFoo() {
        return () -> "Implementacja awaryjna";
    }
}
