package pl.sdacademy.java.spring.hellospringboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.sdacademy.java.spring.hellospringboot.beans.Foo;

@Component
public class FooRunner implements CommandLineRunner {

    private final Foo foo;
    private final Logger logger = LoggerFactory.getLogger(FooRunner.class);

    public FooRunner(Foo foo) {
        this.foo = foo;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Foo output: {}", foo.getData("Ala ma kota"));
    }
}
