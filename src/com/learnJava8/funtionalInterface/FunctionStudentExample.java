package com.learnJava8.funtionalInterface;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionStudentExample {


    public static Function<List<Student>, Map<String,Double>> studentFunction = (students -> {

        Map<String,Double> studentGradeMap = new HashMap<>();

        students.forEach(student -> {
            if(StudentPredicate.p1.test(student)) {
                studentGradeMap.put(student.getName(), student.getGpa());
            }
        });
        return studentGradeMap;
    });

    public static void main(String[] args) {
        List<Student> studentList = StudentDataBase.getAllStudents();
        System.out.println(studentFunction.apply(studentList));
    }
}
