package com.learnJava8.funtionalInterface;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionStudentExample {

    public static BiFunction<List<Student>,Predicate<Student>,Map<String,Double>>
            studentBiFunction =  ((students, studentPredicate) -> {

                Map<String,Double> studentMap = new HashMap<>();
                Predicate<Student> p1 = StudentPredicate.p1;
                students.forEach(student -> {
                    if(studentPredicate.test(student)){
                        studentMap.put(student.getName(),student.getGpa());
                    }
                });
                return studentMap;
    });
    public static void main(String[] args) {



        System.out.println(studentBiFunction.apply(StudentDataBase.getAllStudents(),StudentPredicate.p1));


    }
}
