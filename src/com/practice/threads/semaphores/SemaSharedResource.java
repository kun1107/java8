package com.practice.threads.semaphores;

import java.util.concurrent.Semaphore;

public class SemaSharedResource {

    boolean isAvailable = false;

    public void producer(Semaphore semaphore){
        try {
            semaphore.acquire();

            System.out.println("lock acquired by thread "+
            Thread.currentThread().getName());

            System.out.println(isAvailable);
            Thread.sleep(4000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            semaphore.release();
            System.out.println("lock Released by "+ Thread.currentThread().getName());
        }
    }
}
