package com.practice.threads.readwriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class main {

    public static void main(String[] args) {

        SharedResource resource = new SharedResource();

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        Thread th1 = new Thread(() -> {
            resource.producer(readWriteLock);
        });
        Thread th2 = new Thread(() -> {
            resource.producer(readWriteLock);
        });
        Thread th3 = new Thread(() -> {
            resource.consumer(readWriteLock);
        });
        Thread th4 = new Thread(() -> {
            resource.producer(readWriteLock);
        });

        th1.start();
        th2.start();
        th3.start();
        try {
            th3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        th4.start();


    }
}
