package lab2.example;


public class ModernMessagePrinter extends MessagePrinter {
    @Override
    public void print() {
        System.out.println("<<<" + getMessage() + ">>>");
    }
}
