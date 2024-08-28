package com.practice.threads.CAS;

public class casMain {

    public static void main(String...args){
        casSharedResource sharedResource = new casSharedResource();

        Thread th1 = new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                sharedResource.increment();
            }
        });
        Thread th2 = new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                sharedResource.increment();
            }
        });

        th1.start();
        th2.start();

        try {
            th1.join();

            th2.join();
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sharedResource.getCounter());
    }
}
