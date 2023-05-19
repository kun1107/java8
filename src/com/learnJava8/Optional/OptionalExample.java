package com.learnJava8.Optional;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.Optional;

public class OptionalExample {

    public static String getStudentName(){
        //Student student = StudentDataBase.studentSupplier.get();
        Student student = null;
        if(student!=null){
            return student.getName();
        }
        return null;
    }

    public static Optional<String> getStudentNameOptional(){
        Optional<Student> studentOptional =
                Optional.ofNullable(StudentDataBase.studentSupplier.get());
        //Optional<Student> studentOptional = null;
        if(studentOptional.isPresent()){
            return studentOptional.map(Student::getName);
        }
        return Optional.empty();
    }

    public static void main(String[] args) {

        /*String name = getStudentName();
        if(name != null){
            System.out.println("Length of the student name: "+getStudentName().length());
        }else {
            System.out.println("Name Not Found");
        }*/

        Optional<String> studentNameOptional = getStudentNameOptional();

        if(studentNameOptional.isPresent()){
            System.out.println("Length of name using optional: "+
                    studentNameOptional.get().length());
        }else{
            System.out.println("Name Not Found");
        }
    }
}
