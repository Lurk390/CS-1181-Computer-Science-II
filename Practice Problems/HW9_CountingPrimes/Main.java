// Mahmoud Elbasiouny
package HW9_CountingPrimes;

// import java.util.*;

public class Main {

    public static void main(String[] args) {
        // take two input parameters: number of threads and value n
        // Scanner input = new Scanner(System.in);
        // System.out.print("Enter the number of threads: ");
        // int numThreads = input.nextInt();
        // System.out.print("Enter the value of n: ");
        // int n = input.nextInt();
        // input.close();

        // System.out.println(countPrimes(numThreads, n));

        long time1 = System.currentTimeMillis();
        countPrimes(10000000, 1);
        System.out.println("Time for 1 thread: " + (System.currentTimeMillis() - time1) + " ms");

        long time2 = System.currentTimeMillis();
        countPrimes(10000000, 2);
        System.out.println("Time for 2 threads: " + (System.currentTimeMillis() - time2) + " ms");

        long time3 = System.currentTimeMillis();
        countPrimes(10000000, 3);
        System.out.println("Time for 3 threads: " + (System.currentTimeMillis() - time3) + " ms");

        long time4 = System.currentTimeMillis();
        countPrimes(10000000, 4);
        System.out.println("Time for 4 threads: " + (System.currentTimeMillis() - time4) + " ms");
    }

    // create a method that creates n number of threads and counts the number of primes between 1 and n
    public static int countPrimes(int n, int numThreads) {
        // create threads and count number of primes between 1 and n
        int primes = 0;
        int start = 1;
        int end = n / numThreads;
        // create an array of threads
        PrimeThread[] threads = new PrimeThread[numThreads];
        // create threads and start them
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new PrimeThread(start, end);
            threads[i].start();
            start = end + 1;
            end += n / numThreads;
        }
        // wait for threads to finish
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // count the number of primes
        for (int i = 0; i < numThreads; i++) {
            primes += threads[i].getPrimes(start, end);
        }
        return primes;
    }
}