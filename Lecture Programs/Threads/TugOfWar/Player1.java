package Threads.TugOfWar;

public class Player1 extends Thread {

    private Rope theRope;

    public Player1(Rope theRope) {
        this.theRope = theRope;
    }

    public void run() {
        while (true) {
			synchronized (theRope) {
				System.out.println("Player1 is pulling left");
				theRope.pullLeft();
			}

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
