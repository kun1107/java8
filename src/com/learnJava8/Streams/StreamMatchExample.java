package com.learnJava8.Streams;

import com.learnJava8.student.StudentDataBase;

public class StreamMatchExample {

    public static boolean allMatch(){
        return StudentDataBase.getAllStudents().stream()
                .allMatch(student -> student.getGpa()>=3.9); //pass 3.5 to get as true
        // cz all the student have grades greater than 3.5
    }

    public static boolean anyMatch(){
        return StudentDataBase.getAllStudents().stream()
                .anyMatch(student -> student.getGpa()>=4.0);
    }
    public static boolean noneMatch(){
        return StudentDataBase.getAllStudents().stream()
                .noneMatch(student -> student.getGpa()>=4.1);
    }

    public static void main(String[] args) {

        System.out.println("All Match Result "+allMatch());

        System.out.println("Any Match Result "+anyMatch());
        System.out.println("none Match Result "+noneMatch());
    }
}
