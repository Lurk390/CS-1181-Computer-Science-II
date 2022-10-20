// Mahmoud Elbasiouny
package HW6_LinkedLists;

public class LinkedList {
    
    private Node head;
    private int size;
    
    public LinkedList() {
        head = null;
        size = 0;
    }
    
    public void add(int element) {
        Node newNode = new Node(element);
        
        if (head == null) {
            head = newNode;
            size = 1;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
            size++;
        }
    }
    
    public int getSize() {
        return size;
    }

    public boolean removeN(int element, int n) {
        Node current = head;
        int count = 0;

        while (current != null) {
            if (current.getElement() == element) {
                count++;
            }
            current = current.getNext();
        }
        if (count < n) {
            return false;
        }
        current = head;
        while (current != null) {
            if (current.getElement() == element) {
                current.setElement(current.getNext().getElement());
                current.setNext(current.getNext().getNext());
                n--;
            }
            if (n == 0) {
                break;
            }
            current = current.getNext();
        }
        return true;
    }

    @Override
    public String toString() {
        String s = "";
        if (head == null) {
            return s;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                s += current.toString() + ", ";
                current = current.getNext();
            }
            s += current.toString(); // last item has no trailing comma
            return s;
        }
    }
    
}
