package lab2.example;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@DeprecatedClass(ModernMessagePrinter.class)
@Component
public class MessagePrinter implements Printer {
    @Value("HelloWorld")
    private String message;

    public void print() {
        System.out.println(message);

    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
