package com.learnJava8.defaults;

import java.util.List;

public class MultiplierImp implements Multiplier {


    @Override
    public int multiply(List<Integer> integerList) {
        return integerList.stream()
                .reduce(1,(x,y) -> x*y);
    }

    public int size(List<Integer> integerList){
        System.out.println("Inside MultiplierImp class");
        return integerList.size();
    }


}
