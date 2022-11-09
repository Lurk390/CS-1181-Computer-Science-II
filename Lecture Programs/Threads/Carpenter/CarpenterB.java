package Threads.Carpenter;

public class CarpenterB extends Thread {

    Toolbox tools;

    public CarpenterB(Toolbox tools) {
        this.tools = tools;
    }

    public void run() {
        synchronized (tools.hammer) {
            System.out.println("CarpenterB picked up the hammer.");

            synchronized (tools.wrench) {
                System.out.println("CarpenterB picked up the wrench.");

                System.out.println("CarpenterB finished his work.");
            }
        }
    }
}
