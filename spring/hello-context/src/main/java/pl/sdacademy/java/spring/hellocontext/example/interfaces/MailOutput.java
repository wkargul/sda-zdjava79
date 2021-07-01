package pl.sdacademy.java.spring.hellocontext.example.interfaces;

import org.springframework.stereotype.Component;

@Component
public class MailOutput implements Output{

    @Override
    public boolean supports(Document document) {
        return true;
    }

    @Override
    public void handle(Document document) {
        System.out.println("Mail: " + document.getContent());
    }
}
