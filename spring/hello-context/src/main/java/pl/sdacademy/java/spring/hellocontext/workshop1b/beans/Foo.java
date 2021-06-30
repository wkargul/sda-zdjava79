package pl.sdacademy.java.spring.hellocontext.workshop1b.beans;

import org.springframework.stereotype.Component;

@Component
public class Foo {
    private final Bar bar;
    public Foo(Bar bar) {
        this.bar = bar;
    }
    public String getData(String input) {
        return bar.doWork(input).toString();
    }
}
