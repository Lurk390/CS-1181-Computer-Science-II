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
    
    public void createTask(String label, int timeToComplete) {
        orders.offer(new Task(label, timeToComplete));
    }
    
    public Task acceptTask() {
        while (orders.isEmpty()) {
            // looping until there is a task in the queue to accept
        }
        return orders.poll();
    }
    
    public void setNoMoreOrders() {
        moreOrdersComing = false;
    }
    
    public boolean weAreDone() {
        return orders.isEmpty() && !moreOrdersComing;
    }
}