package Threads.Carpenter;

public class CarpenterA extends Thread {

    Toolbox tools;

    public CarpenterA(Toolbox tools) {
        this.tools = tools;
    }

    public void run() {
        synchronized (tools.wrench) {
            System.out.println("CarpenterA picked up the wrench.");

            synchronized (tools.hammer) {
                System.out.println("CarpenterA picked up the hammer.");

                System.out.println("CarpenterA finished his work.");
            }
        }
    }
}
