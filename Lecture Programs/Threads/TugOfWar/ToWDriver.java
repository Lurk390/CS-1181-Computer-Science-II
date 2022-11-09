package Threads.TugOfWar;

class ToWDriver {

    public static void main(String[] args) throws Exception {

        Rope theRope = new Rope();

        Player1 p1 = new Player1(theRope);
        Player2 p2 = new Player2(theRope);

        p1.start();
        p2.start();

//        int currentLoc = theRope.getLocation();
		int currentLoc = 0;

        while (currentLoc > -3 && currentLoc < 3) {
			synchronized (theRope) {
				currentLoc = theRope.getLocation();
				System.out.println(currentLoc);
			}

            Thread.sleep(10);
        }

        System.exit(0);
    }
}
