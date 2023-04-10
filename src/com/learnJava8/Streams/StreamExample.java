package com.learnJava8.Streams;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExample {
    static Predicate<Student> gradePredicate = student -> student.getGradeLevel()>=3;
    static Predicate<Student> gpaPredicate = student -> student.getGpa()>=3.9;

    public static void main(String[] args) {

        Map<String, List<String>> studentMap = StudentDataBase.getAllStudents().stream()
                .peek((student) -> System.out.println(student)) // debugging in streams
                .filter(gradePredicate)
                .peek(student -> System.out.println("After 1st Filter "+ student))
                .filter(gpaPredicate)
                .peek(student -> System.out.println("After 2nd Filter "+ student))
                .collect(Collectors.toMap(Student::getName,Student::getActivities));

        System.out.println("student Map "+studentMap);
    }
}
