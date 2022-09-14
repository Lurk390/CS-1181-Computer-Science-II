package Polymorphism;
import java.io.Serializable;

public class Student extends Person implements BreathingThing,
Serializable {
    private transient double gpa;

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
