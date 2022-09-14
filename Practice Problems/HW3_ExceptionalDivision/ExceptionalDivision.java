// Mahmoud Elbasiouny

import java.util.Scanner;

public class ExceptionalDivision {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numerator = 0;
        int denominator = 0;

        while (true) {
            try {
                System.out.print("What is the numerator? ");
                numerator = input.nextInt();
                break;
            } catch (Exception InputMismatchException) {
                System.out.println("Error: Please enter a whole number.");
                input.nextLine();
            }
        }

        while (true) {
            try {
                System.out.print("What is the denominator? ");
                denominator = input.nextInt();
                
                if (denominator == 0) {
                    System.out.println("Error. Can not divide by zero.");
                    input.nextLine();
                } else {
                    break;
                }
            } catch (Exception InputMismatchException) {
                System.out.println("Error: Please enter a whole number.");
                input.nextLine();
            }
        }
        input.close();

        int quotient = numerator / denominator;
        System.out.println(numerator + " / " + denominator + " = " + quotient);
    }
}
