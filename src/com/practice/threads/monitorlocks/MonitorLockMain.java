package com.practice.threads.monitorlocks;

public class MonitorLockMain {

    public static void main(String[] args) {

        System.out.println("Current Thread Running: "+ Thread.currentThread().getName());

        MonitorLockTest monitorLockTest = new MonitorLockTest();

        Thread th1 = new Thread(()-> {

            try {
                monitorLockTest.task1();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        Thread th2 = new Thread(()->{
            monitorLockTest.task2();
        });

        Thread th3 = new Thread(() -> {
            monitorLockTest.task3();
        });

        th1.start();
        th2.start();
        th3.start();

    }
}
