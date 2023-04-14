package com.learnJava8.defaults;

public interface Interface3 extends Interface2{

    default void  methodC(){
        System.out.println("Inside Method C");
    }

    default void  methodB(){
        System.out.println("Inside Method B "+Interface3.class);
    }
}
