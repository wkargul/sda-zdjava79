package pl.sdacademy.java.spring.hellocontext.workshop1a;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.sdacademy.java.spring.hellocontext.workshop1a.beans.Foo;

public class Main {
    public static void main(String[] args) {
        ApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("workshop1.xml");
        Foo foo1 = xmlApplicationContext.getBean(Foo.class);
        System.out.println(foo1.getData("Ala ma kota"));
    }
}
