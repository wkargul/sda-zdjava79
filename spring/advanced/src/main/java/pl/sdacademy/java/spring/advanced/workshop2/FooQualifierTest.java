package pl.sdacademy.java.spring.advanced.workshop2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FooQualifierTest implements CommandLineRunner {
    private Foo foo1;
    private Foo foo2;
    private Foo foo3;
    private Foo foo4;

    public FooQualifierTest(
        @Qualifier("foo1") Foo foo1,
        @Qualifier("foo2") Foo fooXyz, //nazwa wg qualifiera, nazwa parametru nie ma znaczenia
        @Qualifier("foo3") Foo foo3,
        Foo foo4 //wyszukiwanie komponentu wg nazwy parametru konstruktora
    ) {
        this.foo1 = foo1;
        this.foo2 = fooXyz;
        this.foo3 = foo3;
        this.foo4 = foo4;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
