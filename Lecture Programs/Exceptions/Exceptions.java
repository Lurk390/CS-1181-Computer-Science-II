package Exceptions;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exceptions {
    public static void main(String[] args) {
        /*
        String s = "hello";

        if (Math.random() < 1.0) {
            s = null;
        }
        System.out.println(s.length());
        */
        String filename = "Lecture Programs/Exceptions/name.txt";

        try {
            Scanner in = new Scanner(new File(filename));
            System.out.println("Hello " + in.nextLine());
            int x = 9;
            int y = 0;
            int z = x / y;
        } catch (FileNotFoundException e1) {
            System.out.print("Greetings! What is your name? ");
            Scanner keyboard = new Scanner(System.in);
            String name = keyboard.nextLine();
            keyboard.close();

            try {
                PrintWriter pw = new PrintWriter(filename);
                pw.println(name);
                pw.close();
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }  
        } catch (ArithmeticException e3) {
            System.out.println("Error: Can not divide by zero.");
        }
    }
}
