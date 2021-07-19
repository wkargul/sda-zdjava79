package pl.sdacademy.java.spring.advanced.workshop2;

import org.springframework.stereotype.Component;

@Component("foo1")
public class Foo {
    private final String text;

    public Foo() {
        this.text = "Component scan";
    }

    public Foo(String text) {
        this.text = text;
    }
}
