package SearchingandSorting;

class Search {

    public static void main(String[] args) {

        int[] arr = {11, 21, 37, 39, 42, 68, 103, 109};
        System.out.println(search(arr, 42));
        System.out.println(search(arr, 57));
    }

    public static int search(int[] arr, int target) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
