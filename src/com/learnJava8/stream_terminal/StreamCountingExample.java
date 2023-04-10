package com.learnJava8.stream_terminal;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class StreamCountingExample {

    public static long countNumberOfStudents(){
        return StudentDataBase.getAllStudents().stream()
                .collect(counting());
    }

    public static void main(String[] args) {
        System.out.println(countNumberOfStudents());

    }
}
