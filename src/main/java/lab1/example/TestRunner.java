package lab1.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestRunner {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("lab1/example/context.xml");
        Printer printer = context.getBean(Printer.class);
        printer.print();
    }
}
