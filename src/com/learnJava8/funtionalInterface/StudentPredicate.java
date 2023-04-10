package com.learnJava8.funtionalInterface;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.List;
import java.util.function.Predicate;

public class StudentPredicate {

    static List<Student> studentList = StudentDataBase.getAllStudents();
    //get student whose grade is greater than 3
    static Predicate<Student> p1 = student -> student.getGradeLevel()>=3;

    static Predicate<Student> p2 = student -> student.getGpa()>=3.9;


    public static void getStudentByGrade(){
        System.out.println("filtered By Grade: ");
        studentList.forEach(student -> {
            if (p1.test(student)){
                System.out.println(student);
            }
        });
    }
    public static void getStudentGradeAndGpa(){
        System.out.println("filtered By Grade and GPA: ");
        studentList.forEach(student -> {
            if (p1.and(p2).test(student)){
                System.out.println(student);
            }
        });
    }

    public static void main(String[] args) {

        getStudentByGrade();

        getStudentGradeAndGpa();

    }
}
