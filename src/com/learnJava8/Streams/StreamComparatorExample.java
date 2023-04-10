package com.learnJava8.Streams;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamComparatorExample {

    public static List<Student> sortStudentByName(){

        return StudentDataBase.getAllStudents().stream()
               .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }

    public static List<Student> sortStudentByGpa(){

        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getGpa).reversed()) // revered() to reverse the sorting
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        //sortStudentByName().forEach(System.out::println);
        sortStudentByGpa().forEach(System.out::println);
    }
}
