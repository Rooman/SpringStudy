package lab1.practice;

import lab1.solution.Printer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestRunner {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("lab1/practice/context.xml");
        lab1.solution.Printer printer = context.getBean(Printer.class);
        printer.print();
    }
}
