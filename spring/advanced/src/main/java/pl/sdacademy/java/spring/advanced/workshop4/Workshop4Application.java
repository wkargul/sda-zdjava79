package pl.sdacademy.java.spring.advanced.workshop4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class Workshop4Application {

    public static void main(String[] args) {
        SpringApplication.run(Workshop4Application.class, args);
    }

    @Bean
    @Profile("!prod")
    public Foo fooNonProd(
        @Value("${app.foo.x}") int x,
        @Value("${app.foo.y}") String y
    ) {
        return () -> "Implementacja nieprodukcyjna: " + x + " " + y;
    }
}
