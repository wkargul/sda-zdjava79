package pl.sdacademy.java.spring.advanced.workshop2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BarTest implements CommandLineRunner {
    private final Bar bar;

    public BarTest(Bar bar) {
        this.bar = bar;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
