package com.practice.threads;

public class LifeCycleMain {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        Thread th1 = new Thread(new ConsumerTask(sharedResource),"consumeThread");
        Thread th2 = new Thread(new ProduceTask(sharedResource),"ProduceThread");

        th1.start();
        th2.start();

    }
}
