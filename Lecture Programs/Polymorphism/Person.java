package Polymorphism;
import java.io.Serializable;

public class Person implements Serializable {
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
