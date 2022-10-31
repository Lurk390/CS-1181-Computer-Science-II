package HW8_SummingDigits;

public class Sum {

    // Partial loops and recursive
    public static long sumDigits1(long n) {
        // Split number into array of single digits, then sum until it returns only 1 digit
        if (n > 9) {
            String numString = Long.toString(n);
            String[] stringArray = numString.split("");
    
            long[] longArray = new long[stringArray.length];
            for (int i = 0; i < stringArray.length; i++) {
                longArray[i] = Long.parseLong(stringArray[i]);
            }

            long sum = 0;
            for (int i = 0; i < longArray.length; i++) {
                sum =+ sum + longArray[i];
            }

            return sumDigits1(sum);
        } else {
            return n;
        }
    }

    // Fully recursive
    public static long sumDigits2(long n){
        // Add first two digits and recurse until everything is summed
        if (n < 10) {
            return n;
        } else {
            return sumDigits2(n % 10 + sumDigits2(n / 10));
        }
    }
}
