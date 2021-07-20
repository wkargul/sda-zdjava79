package pl.sdacademy.java.spring.advanced.workshop4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class FooTest {
    private static final Logger logger = LoggerFactory.getLogger(FooTest.class);

    private final Foo foo;
    private final Environment environment;

    public FooTest(Foo foo, Environment environment) {
        this.foo = foo;
        this.environment = environment;
    }

    @PostConstruct
    public void ready() {
        logger.info("Aktywne profile: " + Arrays.toString(environment.getActiveProfiles()));
        logger.info(foo.getMessage());
    }
}
