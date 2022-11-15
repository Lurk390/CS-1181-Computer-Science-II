package Threads.Restaurant;

class Cook implements Runnable {

    Order order;
    
    public Cook(Order order) {
        this.order = order;
    }
    
    @Override
    public void run() {
        System.out.println("The cook has received the order");
        order.cookFood();
    }
}
