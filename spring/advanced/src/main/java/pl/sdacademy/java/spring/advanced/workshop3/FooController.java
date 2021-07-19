package pl.sdacademy.java.spring.advanced.workshop3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {
    private final Foo foo;

    public FooController(Foo foo) {
        this.foo = foo;
    }

    @GetMapping("/")
    public String foo() {
        return foo.getNumber() + ", " + foo.getNumber();
    }
}
