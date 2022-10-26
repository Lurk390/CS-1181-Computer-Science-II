// Mahmoud Elbasiouny
package HW7_Cookies;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many cookies are there? ");
        int numCookies = input.nextInt();

        System.out.print("What are the current sweetness values of these " + numCookies + " cookies? ");
        PriorityQueue<Integer> cookies = new PriorityQueue<Integer>();
        for (int i = 0; i < numCookies; i++) {
            cookies.add(input.nextInt());
        }

        System.out.print("What is the minimum desired sweetness? ");
        int minSweetness = input.nextInt();
        input.close();

        System.out.print("The number of operations required to achieve this is " + sweetness(cookies, minSweetness));
    }

    public static int sweetness(PriorityQueue<Integer> cookies, int minSweetness) {
        int numOperations = 0;
        while (cookies.peek() <= minSweetness) {
            if (cookies.size() == 1) {
                return -1;
            }
            int leastSweetCookie = cookies.poll();
            int secondLeastSweetCookie = cookies.poll();
            int newCookie = leastSweetCookie + (2 * secondLeastSweetCookie);
            cookies.add(newCookie);
            numOperations++;
        }
        return numOperations;
    }
}