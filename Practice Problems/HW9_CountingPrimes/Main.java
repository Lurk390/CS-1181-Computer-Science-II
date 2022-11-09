// Mahmoud Elbasiouny
package HW9_CountingPrimes;

import java.util.*;

public class Main {
    static long executionTime = 0;

    public static void main(String[] args) {
        // take two input parameters: number of threads and value n
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of threads: ");
        int numThreads = input.nextInt();
        System.out.print("Enter the value of n: ");
        int n = input.nextInt();
        input.close();

        System.out.println();
        countPrimes(n, 1);
        System.out.println();
        double singleThreadExecutionTime = executionTime;

        System.out.println("There are " + countPrimes(n, numThreads) + " primes in between 1 and " + n);
        double multiThreadExecutionTime = executionTime;

        double speedup = singleThreadExecutionTime / multiThreadExecutionTime;
        System.out.printf("\nSpeed up: %.2f", speedup);
    }

    // create a method that creates n number of threads and counts the number of primes between 1 and n
    public static int countPrimes(int n, int numThreads) {
        long[] startTime = new long[numThreads];
        long[] endTime = new long[numThreads];

        int totalNumPrimes = 0;
        int start = 1;
        int end = n / numThreads;

        // create an array of threads
        ArrayList<PrimeThread> threads = new ArrayList<>();

        long overallStartTime = System.currentTimeMillis();

        // create threads and start them
        for (int i = 0; i < numThreads - 1; i++) {
            startTime[i] = System.currentTimeMillis();
            threads.add(new PrimeThread(start, end));
            threads.get(i).start();
            start = end;
            end += n / numThreads;
        }

        startTime[numThreads - 1] = System.currentTimeMillis();
        threads.add(new PrimeThread(start, n));
        threads.get(numThreads - 1).start();

        // wait for threads to finish
        for (PrimeThread thread : threads) {
            try {
                thread.join();
                endTime[threads.indexOf(thread)] = System.currentTimeMillis();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long overallEndTime = System.currentTimeMillis();

        // count the number of primes
        for (int i = 0; i < numThreads; i++) {
            int threadNumPrimes = threads.get(i).getPrimes();
            long threadTime = endTime[i] - startTime[i];

            totalNumPrimes += threadNumPrimes;
            System.out.println("Thread " + (i + 1) + " took " + threadTime + " ms and found " + threadNumPrimes + " primes");
        }

        executionTime = overallEndTime - overallStartTime;
        System.out.println("Total execution time: " + executionTime + " ms");

        return totalNumPrimes;
    }
}