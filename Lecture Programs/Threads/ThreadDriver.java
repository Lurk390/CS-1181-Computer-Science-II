package Threads;

class ThreadDriver {

	public static void main(String[] args) throws InterruptedException {

		RedThread t1 = new RedThread();
		Thread t2 = new Thread(new BlueThread());
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Done!");
	}
}