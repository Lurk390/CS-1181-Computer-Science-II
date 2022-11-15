package Threads.Restaurant;

public class WaitNotifyExample {
    
    public static void main(String[] args) {
        
        Order order = new Order("French fries");
        
        Thread waiterThread = new Thread(new Waiter(order));
        Thread cookThread = new Thread(new Cook(order));
        
        waiterThread.start();
        cookThread.start();
    }
}