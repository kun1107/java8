package com.practice.threads.producerConsumer;

import java.util.LinkedList;

public class TestMain {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(6,new LinkedList<>());

        Thread th1 = new Thread(() -> {
            try {
                for(int i  = 1;i<= 6;i++) {
                    sharedResource.consumer();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread th2 = new Thread(() -> {
            try {
                for(int i  = 1;i<= 6;i++) {
                    sharedResource.producer(i);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        th1.start();
        th2.start();
    }
}
