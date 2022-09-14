package Inheritance;

public class ClassB extends ClassA {

    // if I don't write a constructor, java provides 
    // a default no-argument constructor that just calls
    // the super class's default no-arg constructor
    public ClassB() {
        // super(); // I get this automatically
        System.out.println("In ClassB constructor");
    }

    public void methodB() {
        System.out.println("ClassB methodB");
    }

    public void methodC() {
        System.out.println("ClassB methodC");
    }
}
