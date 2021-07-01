package pl.sdacademy.java.spring.hellospringboot.beans;

import org.springframework.stereotype.Component;

@Component
public class Bar {
    public Integer doWork(String input) {
        return input.length();
    }
}
