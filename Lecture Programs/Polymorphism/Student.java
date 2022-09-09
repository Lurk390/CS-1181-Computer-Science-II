package Polymorphism;

public class Student extends Person {
    private double gpa;

    Student(String name, double gpa) {
        super(name);
        this.gpa = gpa;
    }

    // Copy constructor
    Student(Student other) {
        super(other.getName());
        this.gpa = other.gpa;
    }

    public void breathe() {
        System.out.println("The student breathes!");
    }
}
