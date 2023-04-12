package com.learnJava8.defaults;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultMethodExample {

    public static void main(String[] args) {
        List<String> studentList = Arrays.asList("Adam","Eve","Jenny","Zian","Dan");

        System.out.println(studentList);

        /*Prior To Java8*/
        Collections.sort(studentList);
        System.out.println(studentList);

        /*Java8*/
        studentList.sort(Comparator.naturalOrder());
        System.out.println(studentList);

        studentList.sort(Comparator.reverseOrder());
        System.out.println(studentList);

        //replaceAll method

        studentList.replaceAll(String::toUpperCase);
        System.out.println(studentList);
    }
}
