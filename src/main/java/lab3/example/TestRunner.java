package lab3.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestRunner {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Printer printer = context.getBean(Printer.class);
        while (true) {
            printer.print();
        }

    }
}
