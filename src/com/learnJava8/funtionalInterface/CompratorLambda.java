package com.learnJava8.funtionalInterface;

import java.util.Comparator;

public class CompratorLambda {
    public static void main(String[] args) {

        /*Old Style*/

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2); // 0 ==> o1 == o2
                                        // 1 ==> o1>o2,
                                        // -1 ==> o1<o2
            }
        };

        System.out.println("Result of Pre Java 8 Type "+comparator.compare(2,3));

        /*Java Style*/

        Comparator<Integer> comparator1 = (Integer o1,Integer o2) -> o1.compareTo(o2);
        System.out.println("Result of Java 8 Type "+comparator1.compare(2,3));

        Comparator<Integer> comparator2 = (o1,o2) -> o1.compareTo(o2);
        System.out.println("Result of Java 8 Type "+comparator1.compare(2,3));

    }
}
