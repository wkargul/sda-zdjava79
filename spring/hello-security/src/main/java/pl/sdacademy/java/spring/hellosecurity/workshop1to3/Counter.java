package pl.sdacademy.java.spring.hellosecurity.workshop1to3;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.concurrent.atomic.AtomicLong;

@Component
@SessionScope
public class Counter {
    private final AtomicLong seq = new AtomicLong();

    public long next() {
       return seq.getAndIncrement();
    }
}
