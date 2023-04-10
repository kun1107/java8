package com.learnJava8.funtionalInterface;

import java.util.Locale;
import java.util.function.Function;

public class FunctionExample {

    static Function<String,String> function = s-> s.toUpperCase();
    static Function<String,String> addSomeString = s -> (" default ").concat(s);
    public static void main(String[] args) {
        System.out.println("Result is "+ function.apply("java8"));
        System.out.println("addSomeString Result: "+ function.andThen(addSomeString).apply("java8"));
        System.out.println("compose Result is: "+ function.compose(addSomeString).apply("java8"));
    }
}
