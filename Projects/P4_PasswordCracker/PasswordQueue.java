package P4_PasswordCracker;

import java.util.concurrent.ArrayBlockingQueue;

public class PasswordQueue {
    // 26^5 = 11,881,376 possible 5 letter passwords (only lower case)
    // ArrayBlockingQueue is thread-safe and has a fixed size to help with performance
	private static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(12000000);

    public static void add(String password) {
        queue.add(password);
    }

    public static String poll() {
        return queue.poll();
    }

    public static int size() {
        return queue.size();
    }
}
