package com.learnJava8.Optional;

import com.learnJava8.student.Bike;
import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.List;
import java.util.Optional;

public class OptionalMapFlatMapFilterExample {

    //filter
    public static void optionalFilter(){
        Optional<Student> studentOptional =
                Optional.ofNullable(StudentDataBase.studentSupplier.get());

        studentOptional
                .filter(student -> student.getGpa() >= 3)
                .ifPresent(System.out::println);

    }
    //map

    public static void mapExample(){
        Optional<Student> optionalStudent =
                Optional.ofNullable(StudentDataBase.studentSupplier.get());

        Optional<String> optional = optionalStudent.filter(student -> student.getGpa() >= 3)
                .map(Student::getName);

        System.out.println(optional.get());


    }
    //flatMap

    public static void optionalFlatMap(){

        Optional<Student> optionalStudent =
                Optional.ofNullable(StudentDataBase.studentSupplier.get());

        Optional<String> optionalName = optionalStudent
                .filter(student -> student.getGpa()>=3)
                .flatMap(Student::getOptionalBike)
                .map(Bike::getName);

        System.out.println(optionalName);
        optionalName.ifPresent(System.out::println);

    }

    public static void main(String[] args) {

        optionalFilter();
        mapExample();
        optionalFlatMap();


    }
}
