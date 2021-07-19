package pl.sdacademy.java.spring.advanced.workshop2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class Workshop2Application {

    public static void main(String[] args) {
        SpringApplication.run(Workshop2Application.class, args);
    }

    @Bean
    public Foo foo2() {
        return new Foo("Konfiguracja foo2");
    }

    @Bean("foo3")
    public Foo foo2Oszukane() {
        return new Foo("Konfiguracja foo3");
    }

    @Bean
    public Foo foo4() {
        return new Foo("Konfiguracja foo4");
    }

    @Bean
    public Bar bar1() {
        return new Bar("bar1");
    }

    @Bean
    @Primary
    public Bar bar2() {
        return new Bar("bar2");
    }

}
