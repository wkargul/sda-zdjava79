package pl.sdacademy.java.spring.advanced.workshop6;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {

    @GetMapping("/")
    public void foo() {
        throw new FooException("A to niespodzianka!");
    }
}
