package com.learnJava8.stream_terminal;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toSet;

public class StreamPartitioningByExample {

    public static void partitioningBy_1(){

        Predicate<Student> studentPredicate = student -> student.getGpa()>3.8;
        Map<Boolean, List<Student>> studentMap = StudentDataBase.getAllStudents().stream()
                .collect(partitioningBy(studentPredicate));

        System.out.println(studentMap);
    }

    public static void partitioningBy_2(){

        Predicate<Student> studentPredicate = student -> student.getGpa()>3.8;

        Map<Boolean, Set<Student>> studentMap = StudentDataBase.getAllStudents().stream()
                .collect(partitioningBy(studentPredicate,toSet()));

        System.out.println(studentMap);
    }

    public static void main(String[] args) {

        //partitioningBy_1();
        partitioningBy_2();

    }
}
