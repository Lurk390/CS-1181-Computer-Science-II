package Threads.Restaurant;

class Waiter implements Runnable {

    Order order;

    public Waiter(Order order) {
        this.order = order;
    }

    @Override
    public void run() {
        order.deliverFood();
    }
}
