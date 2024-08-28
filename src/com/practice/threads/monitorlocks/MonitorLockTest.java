package com.practice.threads.monitorlocks;

public class MonitorLockTest {

    public synchronized void task1() throws InterruptedException {
        System.out.println("from task1 "+ Thread.currentThread().getName());
        Thread.sleep(10000l);
        System.out.println("Task 1 Completed");
    }

    public void task2(){
        System.out.println("before sync method");
        synchronized(this) {
            System.out.println("from Task2 " + Thread.currentThread().getName());
        }
    }

    public void task3(){
        System.out.println("from task3 "+ Thread.currentThread().getName());
    }

}
