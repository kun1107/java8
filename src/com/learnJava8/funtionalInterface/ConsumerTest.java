package com.learnJava8.funtionalInterface;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {

    static Consumer<Student> c2 = student -> System.out.println(student);
    static Consumer<Student> c3 = student -> System.out.print(student.getName()+" ");
    static Consumer<Student> c4 = student -> System.out.println(student.getActivities());

    static Consumer<Student> c5 = student -> System.out.println(student.getName()+""+student.getActivities());
    static List<Student> studentList =  StudentDataBase.getAllStudents();

    public static void printStudent(){
        studentList.forEach(c2);
    }

    public static void printStudentAndActivity(){
        studentList.forEach(c3.andThen(c4)); // consumer Chaining.
    }

    public static void printStudentAndActivityWithCondition(){

       /* Consumer<Student> studentConsumer = student -> {
            if (student.getGradeLevel() >= 3) {
                c3.andThen(c4).accept(student);
            }
        };*/
        System.out.println("printStudentAndActivityWithCondition");

        studentList.forEach(student -> {
            if(student.getGradeLevel()>=3 && student.getGpa()>=3.9){
                c3.andThen(c4).accept(student);
            }
        });


    }

    public static void main(String[] args) {
        Consumer<String> c1 = s -> System.out.println(s.toUpperCase());
        c1.accept("java8");
      //  printStudent();
        //printStudentAndActivity();
        //printStudentAndActivityWithCondition();

       studentList.forEach(c5);
    }
}
