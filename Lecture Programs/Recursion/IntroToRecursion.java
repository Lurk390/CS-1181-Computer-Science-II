package Recursion;

class IntroToRecursion {

    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(reverse("hello")); // olleh
    }

    // useful String methods:
    // s.length() -- gives you the length of the string
    // s.charAt(i) -- gives you the character at index i of the string
    // s.substring(i) -- gives you the substring starting at the ith index
    public static String reverse(String s) {

        if (s.length() == 1) {
            return s;
        }

        // hello
        // ello -> olle
        return reverse(s.substring(1)) + s.charAt(0);
    }

    // return n!, must be recursive
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        } 
        return n * factorial(n-1);
    }

    public static int sum(int n) {
        // This is the base case
        // It is the simplest version of the problem, we just
        // immediately return an answer
        if (n <= 0) {
            return 0;
        } 

        // This is the recursive step. It is where the method calls
        // itself, but each call has to have parameters that get 
        // closer and closer to the base case.
        return n + sum(n-1);
    }
}

