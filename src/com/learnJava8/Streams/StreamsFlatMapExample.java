package com.learnJava8.Streams;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsFlatMapExample {

    public static List<String> flatMapStream() {
        List<String> activityList = StudentDataBase.getAllStudents().stream() //Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                .flatMap(List::stream) //Stream<String>
                .collect(Collectors.toList()); //

        return activityList;
    }

    public static List<String> distinctActivities() {
        List<String> activityList = StudentDataBase.getAllStudents().stream() //Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                .flatMap(List::stream) //Stream<String>
                .distinct()
                .sorted() // natural sorting is applied
                .collect(Collectors.toList()); //

        return activityList;
    }

    public static Long countActivities() {

        Long activityCount = StudentDataBase.getAllStudents().stream() //Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                .flatMap(List::stream) //Stream<String>
                .distinct() //distinct action performed
                .count(); //

        return activityCount;
    }

    public static void main(String[] args) {

       // System.out.println(flatMapStream());
        System.out.println("Distinct" + distinctActivities());
        System.out.println("Count " + countActivities());

    }
}
