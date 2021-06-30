package pl.sdacademy.java.spring.hellocontext.workshop1b.beans;

import org.springframework.stereotype.Component;

@Component
public class Bar {
    public Integer doWork(String input) {
        return input.length();
    }
}
