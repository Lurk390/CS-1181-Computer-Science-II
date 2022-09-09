package Polymorphism;

public class Person {
    private String name;

    Person(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
