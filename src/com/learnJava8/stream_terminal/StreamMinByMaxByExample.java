package com.learnJava8.stream_terminal;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamMinByMaxByExample {

    public static Optional<Student> min_By(){
        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));
    }

    public static Optional<Student> max_By(){
        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));
    }

    public static void main(String[] args) {

        System.out.println(min_By());
        System.out.println(max_By());
    }
}
