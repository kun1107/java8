package com.learnJava8.Streams;

import com.learnJava8.student.StudentDataBase;

public class StreamMapReduceExample {

    public static int noOfNotebooks(){
        int totalBooks
        = StudentDataBase.getAllStudents().stream() //Stream<Student>
                .filter(student -> student.getGradeLevel()>=3) //Stream<Student> filtered grade level
                //.peek(student -> System.out.println(student)) // to check value present in current stream
                .map(student -> student.getNoteBooks())
                //.peek(integer -> System.out.println(integer))
               // .reduce(0,(a,b) -> a+b);
                .reduce(0,Integer::sum);

        return totalBooks;
    }

    public static void main(String[] args) {
        System.out.println(noOfNotebooks());
    }
}
