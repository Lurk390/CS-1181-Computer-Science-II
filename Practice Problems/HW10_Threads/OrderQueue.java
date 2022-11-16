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
        // Will only add if there are less than 5 tasks in the queue
        if (orders.size() < 5) {
            orders.add(new Task(label, timeToComplete));
        } else {
            // If there are 5 tasks in the queue, wait until there is room
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
    }
    
    public synchronized Task acceptTask() {
        while (orders.isEmpty()) {
            try {
                System.out.println("waiting...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // looping until there is a task in the queue to accept
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
}