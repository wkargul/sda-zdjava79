package pl.sdacademy.java.spring.hellocontext.workshop1a;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.sdacademy.java.spring.hellocontext.workshop1a.beans.Bar;
import pl.sdacademy.java.spring.hellocontext.workshop1a.beans.Foo;

@Configuration
public class FooConfiguration {

//    @Bean
//    public Foo foo() {
//        return new Foo(new Bar());
//    }

    @Bean
    public Bar bar() {
        return new Bar();
    }

    @Bean
    public Foo foo(Bar bar) {
        return new Foo(bar);
    }
}
