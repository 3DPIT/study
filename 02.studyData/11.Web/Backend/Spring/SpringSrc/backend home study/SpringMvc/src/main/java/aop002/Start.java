package aop002;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app--2/app002.xml");

        Person romeo = context.getBean("boy", Person.class);

        romeo.runSomething();
    }
}
