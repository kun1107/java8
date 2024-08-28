package com.practice.threads.ReentrantLock;
import java.util.concurrent.locks.ReentrantLock;

public class main {


    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        ReentrantLock reentrantLock = new ReentrantLock();

        Thread th1 = new Thread(() -> {
            sharedResource.produce(reentrantLock);
        });


        Thread th2 = new Thread(() -> {
            sharedResource.produce(reentrantLock);
        });

        th1.start();
        th2.start();
    }
}
