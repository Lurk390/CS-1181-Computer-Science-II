// Mahmoud Elbasiouny
package HW6_LinkedLists;

class Main {

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add(3);
    list.add(4);
    list.add(7);
    list.add(6);
    list.add(3);
    list.add(2);
    list.add(9);
    list.add(6);
    list.add(3);
    list.add(6);
    System.out.println(list);
    // 3, 4, 7, 6, 3, 2, 9, 6, 3, 6

    list.removeN(6, 2);
    System.out.println(list);
    // 3, 4, 7, 3, 2, 9, 3, 6
    // 6 was removed 2 times starting from the beginning of the list

    list.removeN(3, 4);
    System.out.println(list);
    // 3, 4, 7, 3, 2, 9, 3, 6
    // No change as there are only 2 occurrences of 3 in the list
  }
}