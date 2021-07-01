package pl.sdacademy.java.spring.hellocontext.workshop2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.sdacademy.java.spring.hellocontext.workshop2.beans.Bar;
import pl.sdacademy.java.spring.hellocontext.workshop2.beans.Foo;

public class Main {
    public static void main(String[] args) {
        ApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("workshop2.xml");
        Foo foo3 = xmlApplicationContext.getBean(Foo.class);
        System.out.println(foo3.getData("Ala ma kota"));

        Foo foo4 = xmlApplicationContext.getBean(Foo.class);

        Bar bar1 = xmlApplicationContext.getBean(Bar.class);
        Bar bar2 = xmlApplicationContext.getBean(Bar.class);
    }
}
