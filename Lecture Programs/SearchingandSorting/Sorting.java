package SearchingandSorting;

import java.util.Arrays;

class Sorting {

    public static void main(String[] args) {

        int[] test = {31, 14, 6, 9, 0, 17, 15, 21, 21, 99, 107};
        selectionSort(test);
        System.out.println(Arrays.toString(test));
    }

    public static void selectionSort(int[] arr) {

        // for each pass
        for (int j=0; j<arr.length; j++) {

            System.out.println(Arrays.toString(arr));

            // find the smallest number in the unsorted part
            int smallestIndex = j;
            for (int i=j+1; i<arr.length; i++) {
                if (arr[i] < arr[smallestIndex]) {
                    smallestIndex = i;
                }
            }

            // swap it with the first number in the unsorted part
            int temp = arr[j];
            arr[j] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }

    }
}
