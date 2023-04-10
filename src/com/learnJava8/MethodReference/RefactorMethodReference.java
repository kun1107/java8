package com.learnJava8.MethodReference;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.function.Predicate;

public class RefactorMethodReference {

    static Predicate<Student> stuPredicate = RefactorMethodReference::greaterThanGradeLevel;

     public static boolean greaterThanGradeLevel(Student s){
         return s.getGradeLevel()>=3;

     }

    public static void main(String[] args) {

        System.out.println(stuPredicate.test(StudentDataBase.studentSupplier.get()));

    }
}
