package Generics;

import java.util.ArrayList;

class Generics {

    public static void main(String[] args) {

        // One big advantage of generics is that we get compile-time type checking

        ArrayList list1 = new ArrayList();
        list1.add("Hello");
        list1.add("my");
        list1.add("name");
        list1.add("is");
        list1.add("Michelle");
        list1.add(27);

        String longest = (String) list1.get(0);
        for (int i=1; i<list1.size(); i++) {
            System.out.println("i = " + i);
            String s = (String) list1.get(i);
            if (s.length() > longest.length()) {
                longest = s;
            }
        }
        System.out.println("The longest string is " + longest);

        /*
        ArrayList<String> list1 = new ArrayList<>();
        //list1.add("Hello");
        list1.add(27);
        String val = list1.get(0);
        */

        String x = returnFirst("hello", "snorkel", "potato");
        System.out.println("x = " + x);

        int y = returnFirst(14, 7, 12);
        System.out.println("y = " + y);

        double z = returnFirst(14.0, 7.0, 21.7);
        System.out.println("z = " + z);
    }

    // The second benefit of generics is that they shorten code by reducing
    // duplication
    // the "extends Comparable <T>"
    public static <T extends Comparable<T>> T returnFirst(T n1, T n2, T n3) {
        if (n1.compareTo(n2) <= 0 && n1.compareTo(n3) <= 0) {
            return n1;
        } else if (n2.compareTo(n1) <= 0 && n2.compareTo(n3) <= 0) {
            return n2;
        } else {
            return n3;
        }
    }
    
    /*
    public static int returnFirst(int n1, int n2, int n3) {
        return n1;
    }

    public static double returnFirst(double n1, double n2, double n3) {
        return n1;
    }

    public static String returnFirst(String n1, String n2, String n3) {
        return n1;
    }
    */
}
