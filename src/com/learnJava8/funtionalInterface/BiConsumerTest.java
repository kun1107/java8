package com.learnJava8.funtionalInterface;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerTest {

    public static void printStudentAndActivity(){
        List<Student> studentList = StudentDataBase.getAllStudents();
        BiConsumer<String,List<String>> stuBC = (name, activities) -> {
            System.out.println("Name: "+ name + ", Activities: "+ activities);
        };
        studentList.forEach(student -> stuBC.accept(student.getName(),student.getActivities()));
    }
    public static void main(String[] args) {
        BiConsumer<Integer,Integer> bc = (integer, integer2) -> System.out.println(integer+" "+integer2);

        bc.accept(1,2);

        BiConsumer<Integer,Integer> multiply = (a,b) -> {
            System.out.println("Multiplication is: "+ (a*b));
        };

        BiConsumer<Integer,Integer> division = (a,b) -> {
            System.out.println("Division is: "+ (a/b));
        };

        multiply.andThen(division).accept(10,5);
        printStudentAndActivity();
    }
}
