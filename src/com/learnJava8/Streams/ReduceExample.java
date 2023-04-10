package com.learnJava8.Streams;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReduceExample {
    /*
    * Reduces the result to single entity
    * getting the sum/divide/multiplication of numbers from list
    * like finding the highest grade student from the list of student*/

    public static Integer reduceExample(List<Integer> integerList){

        return integerList.stream() // stream<Integer>
                //a=1(identity),b=1(from stream), 1*1 = 1
                //a=1(result),b=2, 1*2 = 2
                //a=2,b=3, 2*3 = 6
                //a=6,b=4, 6*4 = 24
                //a=24,b=5, 24*5 = 120 (Result)
                .reduce(1,(a,b)-> (a*b));

    }
    public static Optional<Integer> reduceExampleWithOutIdentity(List<Integer> integerList){

        return integerList.stream() // stream<Integer>
                //a=1(identity),b=1(from stream), 1*1 = 1
                //a=1(result),b=2, 1*2 = 2
                //a=2,b=3, 2*3 = 6
                //a=6,b=4, 6*4 = 24
                //a=24,b=5, 24*5 = 120 (Result)
                .reduce((a,b)-> (a*b));

    }
    public static Optional<Student> highestGPAStudent(){
        return StudentDataBase.getAllStudents().stream() //Stream<Student>
                .reduce((s1,s2) -> s1.getGpa()>s2.getGpa() ? s1 : s2);
    }

    public static void main(String[] args) {

        /*List<Integer> integerList = Arrays.asList(1,2,3,4,5);
        System.out.println(reduceExample(integerList));

        Optional<Integer> result = reduceExampleWithOutIdentity(integerList);
        System.out.println(result.get());
        System.out.println(result.isPresent());*/

        Optional<Student> result = highestGPAStudent();

        if (result.isPresent()){
            System.out.println(result.get());
        }

    }
}
