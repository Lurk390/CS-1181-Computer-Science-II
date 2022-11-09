package Threads;

import java.util.ArrayList;

class SumDriver {

    public static void main(String[] args) throws InterruptedException {
        final int NUM_THREADS = 3;
        int n = 10000;

        // goal is to find the sum of the numbers
        // from 1 to n
        int blockSize = n / NUM_THREADS;

        ArrayList<SumThread> threads = new ArrayList<>();
        for (int i=0; i<NUM_THREADS-1; i++) {
            threads.add(new SumThread(i * blockSize + 1, 
                        (i+1) * blockSize));
            threads.get(i).start();
        }

        // add the last block
        threads.add(new SumThread(
                    (NUM_THREADS-1) * blockSize + 1, n));
        threads.get(threads.size()-1).start();

        for (SumThread t: threads) {
            t.join();
        }

        // get the answer from each thread and sum
        // them up
        long sum = 0;
        for (SumThread t: threads) {
            sum += t.getSum();
        }

        System.out.println("The sum is " + sum);
    }
}
