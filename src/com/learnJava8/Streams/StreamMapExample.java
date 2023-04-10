package com.learnJava8.Streams;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class StreamMapExample {

    public static List<String> nameList(){
        List<String> studentName = StudentDataBase.getAllStudents().stream()
                .map(Student :: getName)
                .map(String::toUpperCase)
                .collect(toList()); //collect(Collectors.toList());
        return studentName;
    }
    public static Set<String> nameSet(){
        Set<String> studentName = StudentDataBase.getAllStudents().stream()
                .map(Student :: getName)
                .map(String::toUpperCase)
                .collect(Collectors.toSet()); //collect(toSet());
        return studentName;
    }
    public static void main(String[] args) {

        System.out.println(nameList());
        System.out.println(nameSet());
    }
}
