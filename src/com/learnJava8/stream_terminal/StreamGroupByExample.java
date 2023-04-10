package com.learnJava8.stream_terminal;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public class StreamGroupByExample {

    public static void groupStudentByGender(){

        Map<String, List<Student>> studentMap = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGender));
        System.out.println(studentMap);
    }

    public static void customizeGroupingByGpa(){
        Map<String, List<Student>> studentMap = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE"));

        System.out.println(studentMap);
    }

    public static void twoLevelGrouping_1(){
        Map<Integer, Map<String, List<Student>>> studentMap = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGradeLevel,
                        groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE")));
         System.out.println(studentMap);
    }

    public static void twoLevelGrouping_2(){
        Map<String, Integer> studentMap = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getName,
                       Collectors.summingInt(Student::getNoteBooks)));
        System.out.println(studentMap);
    }
    public static void threeLevelGrouping(){
        LinkedHashMap<String, Set<Student>> studentMap = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getName, LinkedHashMap::new,toSet()));
        System.out.println(studentMap);
    }

    public static void main(String[] args) {
        //groupStudentByGender();
       // customizeGroupingByGpa();
        //twoLevelGrouping_1();
        //twoLevelGrouping_2();
        threeLevelGrouping();

    }
}
