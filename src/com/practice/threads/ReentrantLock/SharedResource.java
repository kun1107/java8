package com.practice.threads.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    boolean isAvailable = false;

    public void produce(ReentrantLock reentrantLock){

        try {
            reentrantLock.lock();
            System.out.println("The lock acquired by thread "
                    + Thread.currentThread().getName());

            isAvailable = true;
            Thread.sleep(5000);

        }catch (Exception e ){

        }finally {
            reentrantLock.unlock();
            System.out.println("lock released by thread: "
                    +Thread.currentThread().getName());
        }


    }
}
