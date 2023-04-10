package com.learnJava8.stream_terminal;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.summingInt;

public class StreamSumAvgExample {

    public static int sum(){
        return StudentDataBase.getAllStudents().stream()
                .collect(summingInt(Student::getNoteBooks));
    }

    public static double avg(){
        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.averagingInt(Student::getNoteBooks));
    }

    public static void main(String[] args) {

        System.out.println("Sum: "+ sum());
        System.out.println(("Avg: "+ avg()));

    }
}
