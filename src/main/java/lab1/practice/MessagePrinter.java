package lab1.practice;


import org.springframework.beans.factory.annotation.Value;

public class MessagePrinter implements Printer {

    private String message;

    // создать аннотацию и аннотировать поле так, что бы при поднятии контекста
    // в поле инжектилось случайное число от 0 до числа заданого при помощи аннотации
    @InjectRandomInt("maxPrinterCount")
    private int count;

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(message);
        }
    }

    public void setMessage(String message) {

        this.message = message;
    }
}
