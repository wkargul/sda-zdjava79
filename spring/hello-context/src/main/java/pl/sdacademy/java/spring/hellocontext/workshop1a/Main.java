package pl.sdacademy.java.spring.hellocontext.workshop1a;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.sdacademy.java.spring.hellocontext.workshop1a.beans.Foo;

public class Main {
    public static void main(String[] args) {
        ApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("workshop1.xml");
        Foo foo1 = xmlApplicationContext.getBean(Foo.class);
        System.out.println(foo1.getData("Ala ma kota"));

        Foo foo2 = xmlApplicationContext.getBean(Foo.class);

        ApplicationContext annotationApplicationContext = new AnnotationConfigApplicationContext(FooConfiguration.class);
        Foo foo3 = annotationApplicationContext.getBean(Foo.class);
        System.out.println(foo3.getData("Ala ma kota"));

        Foo foo4 = annotationApplicationContext.getBean(Foo.class);
    }
}
