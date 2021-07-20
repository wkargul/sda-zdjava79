package pl.sdacademy.java.spring.advanced.workshop4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class FooTest {
    private static final Logger logger = LoggerFactory.getLogger(FooTest.class);

    private final Foo foo;

    public FooTest(Foo foo) {
        this.foo = foo;
    }

    @PostConstruct
    public void ready() {
        logger.info(foo.getMessage());
    }
}
