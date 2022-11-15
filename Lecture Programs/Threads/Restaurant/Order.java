package Threads.Restaurant;

class Order {
    String order;
    boolean isReady;
    
    public Order(String order) {
        this.order = order;
    }
    
    public synchronized void deliverFood() {

        // this is called a busy loop -- it's repeatedly checking for a change in state
        // and doing nothing else; it is bad and wrong because it is wasteful of computational
        // resources
        while (!isReady) {
            try {
                wait(); // wait until we are notified by the cook 
            } catch (InterruptedException e) {
                System.out.println("Unable to deliver the food!");
            }
        }
        System.out.println("The food is delivered!");
    }
    
    public synchronized void cookFood() {
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Unable to cook the food!");
        }
        
        System.out.println("The food is ready!");
        isReady = true;
        notifyAll();
    }
}
