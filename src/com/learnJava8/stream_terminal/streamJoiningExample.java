package com.learnJava8.stream_terminal;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class streamJoiningExample {

    public static String joining_1(){

        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining());
    }

    public static String joining_2(){

        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining("-"));
    }
    public static String joining_3(){

        return StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .collect(Collectors.joining("-","(",")"));
    }

    public static void main(String[] args) {

        System.out.println("joining_1 "+ joining_1());
        System.out.println("joining_2 "+ joining_2());

        System.out.println("joining_3 "+ joining_3());

    }
}
