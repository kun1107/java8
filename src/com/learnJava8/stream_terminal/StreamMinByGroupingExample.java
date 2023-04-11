package com.learnJava8.stream_terminal;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamMinByGroupingExample {

    public static void leastGPAStudent(){
     Map<Integer,Student> studentMap =    StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.collectingAndThen(
                                Collectors.minBy(Comparator.comparing(Student::getGpa)),Optional::get)));

        System.out.println(studentMap);
    }
    public static void main(String[] args) {
        leastGPAStudent();

    }
}
