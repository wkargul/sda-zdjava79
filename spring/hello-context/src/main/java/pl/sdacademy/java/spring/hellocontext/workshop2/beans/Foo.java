package pl.sdacademy.java.spring.hellocontext.workshop2.beans;

import org.springframework.stereotype.Service;

@Service
public class Foo {
    private final Bar bar;
    public Foo(Bar bar) {
        this.bar = bar;
    }
    public String getData(String input) {
        return bar.doWork(input).toString();
    }
}
