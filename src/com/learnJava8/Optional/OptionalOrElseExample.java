package com.learnJava8.Optional;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import javax.swing.text.html.Option;
import java.util.Optional;

public class OptionalOrElseExample {

    public static String orElse(){

       Optional<Student> studentOptional =
               Optional.ofNullable(StudentDataBase.studentSupplier.get());

        //to return default value
        //Optional<Student> student = Optional.ofNullable(null);

       String name = studentOptional.map(Student::getName).orElse("Default");

       return name;
    }


    public static String orElseGet(){
        Optional<Student> studentOptional =
                 Optional.ofNullable(StudentDataBase.studentSupplier.get());
        //to return default value
        //Optional<Student> student = Optional.ofNullable(null);
        String name = studentOptional.map(Student::getName).orElseGet(()->"Default");
        return name;
    }
    /*When you want to throw runtime exception when actual value is not present
    * then we can use orElseThrow*/
    public static String orElsetThrow(){
       /* Optional<Student> studentOptional =
                Optional.ofNullable(StudentDataBase.studentSupplier.get());*/
        //to return default value
        Optional<Student> studentOptional = Optional.ofNullable(null);
        String name = studentOptional.map(Student::getName)
                .orElseThrow(()-> new RuntimeException("No data Available"));
        return name;
    }

    public static void main(String[] args) {

        System.out.println("orElse : "+ orElse());
        System.out.println("orElseGet : "+ orElseGet());
        System.out.println("orElseThrow : "+ orElsetThrow());

    }
}
