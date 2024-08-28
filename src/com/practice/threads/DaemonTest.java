package com.practice.threads;

public class DaemonTest {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName()+ " thread started");

        Thread th1 = new Thread(()-> {
            System.out.println(Thread.currentThread().getName()+
                    " thread started");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+
                    " thread Ended");

        });

        Thread th2 = new Thread(()-> {
            System.out.println(Thread.currentThread().getName()+
                    " thread started");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+
                    " thread ended");
        });

        th1.setDaemon(true);
        th1.start();

        th2.start();

        System.out.println(Thread.currentThread().getName()+ " thread Ended");


    }
}
