package Lists;

public class MyLinkedList {
    private Node head;
    private Node tail;

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    public String toString() {
        String s = "";
        Node current = head;
        while (current != null) {
            s += current.element + " ";
            current = current.next;
        }
        return s;
    }

    public void addFirst(String value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = head;
        }
    }

    public void addLast(String value) {
        Node newNode = new Node(value);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        myList.addFirst("Mike");
        myList.addFirst("Joe");
        myList.addFirst("Will");
        myList.addFirst("Sean");
        System.out.println(myList);
        System.out.println("Second time");
        myList.addLast("Matt");
        System.out.println(myList);
    }
}

class Node {
    String element;
    Node next;

    public Node(String value) {
        this.element = value;
    }
}
