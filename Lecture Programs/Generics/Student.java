package Generics;

import java.util.ArrayList;

public class Student<E> {
    private String name;
    private ArrayList<E> grades;

    public Student(String name) {
        this.name = name;
        grades = new ArrayList<>();
    }

    public void addGrade(E grade) {
        grades.add(grade);
    }

    public E getGradeOnAssignment(int assignment) {
        return grades.get(assignment - 1);
    }
}
