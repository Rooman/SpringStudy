package lab3.practice;

@Logger
public class MessagePrinter implements Printer {
    private String message;

    public void print() {
        try {
            System.out.println(message);
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
