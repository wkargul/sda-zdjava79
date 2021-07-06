package pl.sdacademy.java.spring.hellotemplates.workshop4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloMustacheController {

    @GetMapping("/hello-mustache")
    public String helloJsp(Model model) {
        model
                .addAttribute("firstName", "Jan")
                .addAttribute("lastName", "Kowalski")
                .addAttribute("birthDate", 1933);

        return "hello";
    }
}
