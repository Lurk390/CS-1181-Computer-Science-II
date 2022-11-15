package Threads.ColoredThreads;

public class BlueThread implements Runnable {

    public void run() {
        for (int i=0; i<100; i++) {
            System.out.println("Hello from BlueThread " + i);
        }
    }
}
