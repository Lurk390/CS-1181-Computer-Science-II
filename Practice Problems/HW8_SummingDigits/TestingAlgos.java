// Mahmoud Elbasiouny
package HW8_SummingDigits;

public class TestingAlgos {

    public static void main(String[] args) {
        long num = 999999999999L;

        // Algo #1 (partial loops and recursive)
        System.out.println("Algo #1: " + Sum.sumDigits1(num));
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Sum.sumDigits1(num);
        }
        long endTime1 = System.currentTimeMillis();
        long time1 = endTime1 - startTime1; 
        System.out.println("Execution time: " + time1 + " milliseconds");

        // Algo #2 (fully recursive)
        System.out.println("Algo #2: " + Sum.sumDigits1(num));
        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Sum.sumDigits2(num);
        }
        long endTime2 = System.currentTimeMillis();
        long time2 = endTime2 - startTime2;
        System.out.println("Execution time: " + time2 + " milliseconds\n");

        if (time2 > time1) {
            long x = time2/time1;
            System.out.println("Algo #1 was " + x + " times faster");
        } else {
            long y = time1/time2;
            System.out.println("Algo #2 was " + y + " times faster");
        }
    }
}