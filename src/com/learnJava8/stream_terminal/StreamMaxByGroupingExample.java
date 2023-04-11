package com.learnJava8.stream_terminal;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.maxBy;

public class StreamMaxByGroupingExample {

    public static void maxByGrouping(){

        Map<Integer, Optional<Student>> studentgradeMap = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(student -> student.getGradeLevel(),
                        maxBy(Comparator.comparing(Student::getGpa))));
        System.out.println(studentgradeMap);

        // if do not want to return optional use collectingAndThen method and pass maxBy in that
        Map<Integer, Student> studentgradeMap1 = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(student -> student.getGradeLevel(),
                        collectingAndThen(maxBy(Comparator.comparing(Student::getGpa)),Optional::get)));
        System.out.println(studentgradeMap1);
    }

    public static void main(String[] args) {
        maxByGrouping();

    }
}
