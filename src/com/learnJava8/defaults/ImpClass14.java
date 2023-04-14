package com.learnJava8.defaults;

public class ImpClass14 implements Interface1,Interface4{
    @Override
    public void methodA() {
        Interface1.super.methodA();
    }

    public static void main(String[] args) {
        ImpClass14 impClass14 = new ImpClass14();

        impClass14.methodA();
    }
}

