package Lists;

import java.util.*;

class Lists {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        // ArrayList<Integer> list = new ArrayList<Integer>(); // Much slower
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 1000000; i++) {
            list.add(0, (int)(Math.random() * 100));
        }
        System.out.println(list.get(500000));

        long endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " ms\n");

        String[] names = {"Sean", "Will", "Joe", "Mike"};
        for (String name : names) {
            System.out.println(name);
        }
    }
}