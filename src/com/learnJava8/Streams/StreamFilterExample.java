package com.learnJava8.Streams;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterExample {

    public static List<Student> filterNyGender(){

        return StudentDataBase.getAllStudents().stream() //stream<Student>
                .filter(student -> student.getGender().equals("female")) //Stream<Student>
                // filtered with gender  = "female"
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        filterNyGender().forEach(System.out::println);

    }
}

