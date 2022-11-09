package Threads.TugOfWar;

public class Player2 extends Thread {

    Rope theRope;

    public Player2(Rope theRope) {
        this.theRope = theRope;
    }

    public void run() {
        while (true) {

			synchronized (theRope) {
				System.out.println("Player2 is pulling right.");
				theRope.pullRight();
			}

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
