package Generics;

public class StudentDriver {
    
    public static void main(String[] args) {
        Student<Double> s1 = new Student<>("Alice");
        s1.addGrade(100.0);
        s1.addGrade(85.5);
        double a2Grade = s1.getGradeOnAssignment(2);
        System.out.println(a2Grade);
    }
}
