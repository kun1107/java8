package com.learnJava8.defaults;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class DefaultMethodExample2 {

    static Consumer<Student> studentConsumer = System.out::println;
    static Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
    static Comparator<Student> gradeComparator = Comparator.comparing(Student::getGradeLevel);

    public static void sortByName(List<Student> studentList){

        studentList.sort(nameComparator);
        System.out.println("After sortByName:");
        studentList.forEach(studentConsumer);
    }
    public static void sortByGPA(List<Student> studentList){
        Comparator<Student> gpaComparator = Comparator.comparingDouble(Student::getGpa);
        studentList.sort(gpaComparator);
        System.out.println("After sortByGPA:");
        studentList.forEach(studentConsumer);
    }

    public static void sortwithNullValues(List<Student> studentList){
        Comparator<Student> studentComparator = Comparator.nullsFirst(nameComparator);
        studentList.sort(studentComparator);
        System.out.println("After sortwithNullValues:");
        studentList.forEach(studentConsumer);

    }

    public static void comparatorChaining(List<Student> studentList){

        studentList.sort(gradeComparator.thenComparing(nameComparator));

        System.out.println("After comparatorChaining:");
        studentList.forEach(studentConsumer);

    }
    public static void main(String[] args) {

        List<Student> studentList = StudentDataBase.getAllStudents();

        System.out.println("Before Sort:");
        studentList.forEach(studentConsumer);

        //sortByName(studentList);
        //sortByGPA(studentList);
        //comparatorChaining(studentList);
        sortwithNullValues(studentList);
    }
}
