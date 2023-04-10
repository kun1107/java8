package com.learnJava8.funtionalInterface;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateConsumer {

    Predicate<Student> p1 = student -> student.getGpa() ==3.9;
    Predicate<Student> p2 = student -> student.getGradeLevel()>=3;
    BiConsumer<String, List<String>> studentBiConsumer =
            (name,activities) -> System.out.println(name +" "+ activities);

    Consumer<Student> studentConsumer = (student -> {
        if(p1.and(p2).test(student)){
            studentBiConsumer.accept(student.getName(),student.getActivities());
        }
    });

    public void printNameAndActivities(List<Student> students){
        students.forEach(studentConsumer);

    }
    public static void main(String[] args) {

        List<Student> studentList = StudentDataBase.getAllStudents();
        new PredicateConsumer().printNameAndActivities(studentList);
    }
}
