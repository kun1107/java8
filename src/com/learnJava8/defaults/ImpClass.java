package com.learnJava8.defaults;

public class ImpClass implements Interface1,Interface2,Interface3{

    public void  methodA(){
        System.out.println("Inside Method A "+ImpClass.class);
    }
    public static void main(String[] args) {
        ImpClass impClass = new ImpClass();
        Interface1 int1 = new ImpClass();
        int1.methodA();
        impClass.methodA(); // at runtime java resolve the child implementation
        //impClass.methodB();
        //impClass.methodC();
    }
}
