// Mahmoud Elbasiouny
package HW8_SummingDigits;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number: ");
        long num = input.nextLong();
        input.close();

        System.out.println("The recursive sum of the digits of " + num + " is " + Sum.sumDigits2(num));
    }
}
