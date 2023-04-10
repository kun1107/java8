package com.learnJava8.funtionalInterface;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

    static Supplier<Student> studentSupplier = () -> {
      return new Student("Adam",2,3.6, "male", Arrays.asList("swimming", "basketball","volleyball"));
    };


    public static void main(String[] args) {
        System.out.println(studentSupplier.get());

        Supplier<List<Student>> listSupplier = () -> StudentDataBase.getAllStudents();
        System.out.println(listSupplier.get());
        List<Student> students = listSupplier.get();


    }
}
