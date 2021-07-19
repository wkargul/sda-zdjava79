package pl.sdacademy.java.spring.advanced.workshop3;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Random;

@SpringBootApplication
public class Workshop3Application {

    public static void main(String[] args) {
        SpringApplication.run(Workshop3Application.class, args);
    }

    @Bean
    public Random random() {
        return new Random();
    }

    @Bean
//    @RequestScope
    @Scope(scopeName = BeanDefinition.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Foo foo(Random random) {
        return new Foo(random.nextInt());
    }
}
