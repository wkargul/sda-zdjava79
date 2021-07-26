package pl.sdacademy.java.spring.hellosecurity.workshop1to3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public String helloSecurity() {
        return "Hello Spring Security!";
    }
}
