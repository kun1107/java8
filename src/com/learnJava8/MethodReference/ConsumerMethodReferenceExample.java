package com.learnJava8.MethodReference;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.function.Consumer;

public class ConsumerMethodReferenceExample {

  /*
  * without method reference
  */
    static Consumer<Student> studentConsumer = student -> {
        System.out.println("without method reference: "+student);
    };
    /*
    * with method reference
    */
    static Consumer<Student> methodReferenceConsumer = System.out::println;



    public static void main(String[] args) {
       // StudentDataBase.getAllStudents().forEach(studentConsumer);
        StudentDataBase.getAllStudents().forEach(methodReferenceConsumer);
    }
}
