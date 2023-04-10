package com.learnJava8.stream_terminal;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class StreamMappingExample {

    public static void main(String[] args) {

        List<String> studentList = StudentDataBase.getAllStudents().stream()
                .collect(mapping(Student::getName,toList()));
        System.out.println(studentList);

        Set<String> studentSet = StudentDataBase.getAllStudents().stream()
                .collect(mapping(Student::getName,toSet()));

        System.out.println(studentSet);
        // extra step in using the map function then mapping().
       List<String> stuList =  StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(toList());
        System.out.println(stuList);


    }
}
