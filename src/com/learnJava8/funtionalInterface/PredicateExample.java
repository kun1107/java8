package com.learnJava8.funtionalInterface;

import java.util.function.Predicate;

public class PredicateExample {
    static Predicate<Integer> p1 = a -> a%2 == 0;
    static Predicate<Integer> p2 = b-> b%5 == 0;

    public static void predicateTest() {
        System.out.println(p1.test(10));
        System.out.println(p2.test(10));
    }

    public static void predicateAnd(){
        System.out.println("predicateAnd Result is: "+p1.and(p2).test(10));
        System.out.println("predicateAnd Result is: "+p1.and(p2).test(8));
    }

    public static void predicateOr(){
        System.out.println("predicateOr Result is: "+ p1.or(p2).test(10));
        System.out.println("predicateOr Result is: "+p1.or(p2).test(9));
    }

    public static void predicateNegate(){
        System.out.println("predicateNegate Result is: "+ p1.or(p2).negate().test(10));
        System.out.println("predicateNegate Result is: "+p1.or(p2).negate().test(9));
    }


    public static void main(String[] args) {

        //predicateTest();
        predicateAnd();
        predicateOr();
        predicateNegate();

    }
}

