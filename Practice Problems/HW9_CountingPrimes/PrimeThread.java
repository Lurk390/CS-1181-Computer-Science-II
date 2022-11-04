// Mahmoud Elbasiouny
package HW9_CountingPrimes;

public class PrimeThread extends Thread {
    // count then number of primes in the range [start, end]
    private int start;
    private int end;
    private int primes;

    public PrimeThread(int start, int end) throws IllegalArgumentException {
        this.start = start;
        this.end = end;
        primes = 0;
    }

    public static boolean isPrime(int n) { 
        if (n <= 1)
            return false; 
        if (n <= 3)
            return true; 
        if (n % 2 == 0 || n % 3 == 0)
            return false; 
        for (int i=5; i*i <= n; i+=6)
            if (n % i == 0 || n % (i+2) == 0)  
                return false;
        return true; 
    }

    public int getPrimes(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primes++;
            }
        }
        return primes;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primes++;
            }
        }
    }
}
