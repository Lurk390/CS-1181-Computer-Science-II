// Mahmoud Elbasiouny
package HW10_Threads;

import java.util.ArrayDeque;
import java.util.Queue;

class OrderQueue {
    private Queue<Task> orders;
    private boolean moreOrdersComing;
    
    public OrderQueue() {
        orders = new ArrayDeque<>();
        moreOrdersComing = true;
    }
    
    public synchronized void createTask(String label, int timeToComplete) {
        while (orders.size() >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        orders.add(new Task(label, timeToComplete));
        notifyAll();
    }
    
    public synchronized Task acceptTask() {
        while (orders.isEmpty()) {
            // looping until there is a task in the queue to accept
            try {
                System.out.println("waiting...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        return orders.poll();
    }
    
    public void setNoMoreOrders() {
        moreOrdersComing = false;
    }
    
    public boolean weAreDone() {
        return orders.isEmpty() && !moreOrdersComing;
    }

    public int size() {
        return orders.size();
    }
}