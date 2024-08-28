package com.practice.threads.optimisticlock;
import java.util.concurrent.locks.StampedLock;

public class mainStampedLock {
    public static void main(String[] args) {

        StampedLock lock = new StampedLock();

        SharedResource sharedResource = new SharedResource();

        Thread th1 = new Thread(() -> {
            sharedResource.producer(lock);
        });

        Thread th2 = new Thread(() -> {
            sharedResource.consumer(lock);
        });

        th1.start();
       // th2.start();
    }
}
