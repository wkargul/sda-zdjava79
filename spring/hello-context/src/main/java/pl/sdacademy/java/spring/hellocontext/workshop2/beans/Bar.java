package pl.sdacademy.java.spring.hellocontext.workshop2.beans;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Bar {
    public Integer doWork(String input) {
        return input.length();
    }
}
