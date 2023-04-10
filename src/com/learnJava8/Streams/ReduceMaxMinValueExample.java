package com.learnJava8.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceMaxMinValueExample {

    //   recommended to use optional when calculating the max value
    // if we use identity of reduce() than might be possibility of returning default value
    // passed as identity.
    // not to pass default value in case of calculating min value

    public static Optional<Integer> maxValue(List<Integer> integerList){

        return integerList.stream()
                //1 -> b
                //3 -> b
                //5-> b
                //7-> b
                //8-> b
                //10-> b
                //a variable holds max value for each element in the  iteration
               .reduce((a,b) ->  a>b ? a:b);
               // .reduce((a,b) -> Integer.max(a,b));
    }
    public static Optional<Integer> minValue(List<Integer> integerList){

        return integerList.stream()
                .reduce((a,b) -> (a<b) ? a:b);
    }

    public static void main(String...args){

        List<Integer> integerList = Arrays.asList(6,7,8,9,10);
        Optional<Integer> max = maxValue(integerList);
        if(max.isPresent()){
            System.out.println("Max Values is " +max.get());
        }

        Optional<Integer> min = minValue(integerList);
        if(min.isPresent()){
            System.out.println("Min Values is "+min.get());
        }
    }
}
