package com.learnJava8.Optional;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.Optional;

public class OptionalPresentExample {

    public static void isPresentExample(){

        Optional<Student> studentOptional =  Optional.ofNullable
                (StudentDataBase.studentSupplier.get());
        System.out.println("isPresent "+studentOptional.isPresent());
        if(studentOptional.isPresent()){
            String name = studentOptional.map(Student::getName).get();
            System.out.println(name);
        }

    }

    public static void ifPresentExample(){
        Optional<String> optionalString = Optional.ofNullable("Hello");
        optionalString.ifPresent((s)-> System.out.println(s));
    }
    public static void main(String[] args) {
        isPresentExample();
        ifPresentExample();

    }
}
