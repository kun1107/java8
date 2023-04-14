package com.learnJava8.defaults;

import java.util.Arrays;
import java.util.List;

public class MultiplierClient {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,3,5);
        MultiplierImp multiplyImp = new MultiplierImp();
        int result = multiplyImp.multiply(integerList);
        System.out.println("Multiply result: "+result);

        int size = multiplyImp.size(integerList);

        System.out.println("default method result: "+ size);
        System.out.println("static method result: "+ Multiplier.isEmpty(integerList));
    }
}
