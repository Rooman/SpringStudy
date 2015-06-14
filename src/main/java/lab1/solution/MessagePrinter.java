package lab1.solution;


public class MessagePrinter implements Printer {
    private String message;

    public void print() {
        System.out.println(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
