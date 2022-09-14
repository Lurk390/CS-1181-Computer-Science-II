package Inheritance;

public class ClassA extends Object {

    private int field1;

    // if I do write a constructor, I no longer get the default
    // one for free
    public ClassA(int field1) {
        this.field1 = field1;
    }

    public ClassA() {
        // super(); // I get this automatically
        System.out.println("In ClassA constructor");
        field1 = 0;
    }

    public void methodA() {
        System.out.println("ClassA methodA");
    }

    public void methodB() {
        System.out.println("ClassA methodB");
    }
}
