package com.practice.threads.semaphores;

import java.util.concurrent.Semaphore;

public class mainSemaphore {

    public static void main(String[] args) {
        SemaSharedResource sharedResource = new SemaSharedResource();
        Semaphore semaphore = new Semaphore(2);

        Thread th1 = new Thread(
                () -> {
                    sharedResource.producer(semaphore);
                });

        Thread th2 = new Thread(
                () -> {
                    sharedResource.producer(semaphore);
                });

        Thread th3 = new Thread(
                () -> {
                    sharedResource.producer(semaphore);
                });

        Thread th4 = new Thread(
                () -> {
                    sharedResource.producer(semaphore);
                });

        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}
