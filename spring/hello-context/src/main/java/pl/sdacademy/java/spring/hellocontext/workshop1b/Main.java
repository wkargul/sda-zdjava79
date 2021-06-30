package pl.sdacademy.java.spring.hellocontext.workshop1b;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.sdacademy.java.spring.hellocontext.workshop1b.beans.Foo;

public class Main {
    public static void main(String[] args) {
        ApplicationContext annotationApplicationContext = new AnnotationConfigApplicationContext(FooConfiguration.class);
        Foo foo3 = annotationApplicationContext.getBean(Foo.class);
        System.out.println(foo3.getData("Ala ma kota"));

        Foo foo4 = annotationApplicationContext.getBean(Foo.class);
    }
}
