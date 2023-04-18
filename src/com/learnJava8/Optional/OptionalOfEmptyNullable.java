package com.learnJava8.Optional;

import com.learnJava8.student.Student;
import com.learnJava8.student.StudentDataBase;

import java.util.Optional;

public class OptionalOfEmptyNullable {



    /*Used for creating Optional object, can be used when you are sure that
    * input is valid all the time
    * Optional.of(null) will throw null pointer exception*/
    public static Optional<String> optionalOf(){
        return Optional.of("Hello");
    }

    /*
    * Used for creating Optional object,used when you are not sure if the value passed contains null
    * so that isPresent: to check if value is present or not
    * or get method can be used.
    */
    public static Optional<String> ofNullable(){
        Optional<String> optionalString = Optional.ofNullable("Hello");
        return optionalString;
    }

    public static Optional<String> empty(){
        return Optional.empty();
    }


    public static void main(String[] args) {

        System.out.println("ofNullable() "+ofNullable().get());
        System.out.println("of "+optionalOf().get());
        System.out.println("empty: "+ empty().isPresent());
    }
}
