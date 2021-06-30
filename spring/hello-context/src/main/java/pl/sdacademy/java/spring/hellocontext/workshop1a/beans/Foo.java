package pl.sdacademy.java.spring.hellocontext.workshop1a.beans;

public class Foo {
    private final Bar bar;
    public Foo(Bar bar) {
        this.bar = bar;
    }
    public String getData(String input) {
        return bar.doWork(input).toString();
    }
}
