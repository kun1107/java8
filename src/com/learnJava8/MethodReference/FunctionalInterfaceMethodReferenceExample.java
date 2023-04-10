package com.learnJava8.MethodReference;

import java.util.function.Function;

public class FunctionalInterfaceMethodReferenceExample {

    static Function<String,String> toUpperCaseLambda = (s) -> s.toUpperCase() ;
    static Function<String,String> methodReferenceLambda = String::toUpperCase;
    

    public static void main(String[] args) {
        System.out.println(toUpperCaseLambda.apply("java8"));
        

        System.out.println("Method Reference: "+methodReferenceLambda.apply("java8"));
        
        
        
    }
}
