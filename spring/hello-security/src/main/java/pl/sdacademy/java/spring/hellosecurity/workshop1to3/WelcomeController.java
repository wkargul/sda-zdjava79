package pl.sdacademy.java.spring.hellosecurity.workshop1to3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    private final Counter counter;

    public WelcomeController(Counter counter) {
        this.counter = counter;
    }

    @GetMapping("/")
    public String helloSecurity() {
        return "Hello Spring Security!";
    }

    @GetMapping("/count")
    public String countMessage() {
        return "Licznik: " + counter.next();
    }
}
