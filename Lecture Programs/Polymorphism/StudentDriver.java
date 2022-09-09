package Polymorphism;

public class StudentDriver {
    public static void main(String[] args) {
        Student s1 = new Student("John Doe", 3.8);
        Student s2 = new Student(s1);

        System.out.println("s1 = " + s1);
        System.out.println("s2 = "+ s2);

        s2.setName("Bob Jones");

        System.out.println("s1 = " + s1);
        System.out.println("s2 = "+ s2);
    }
}
