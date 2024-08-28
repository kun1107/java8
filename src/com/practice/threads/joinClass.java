package com.practice.threads;

public class joinClass {

    SharedResource sharedResource = new SharedResource();

    public static void main(String[] args) {

        System.out.println("Main Thread Started "+ Thread.currentThread().getName());


        Thread th1 = new Thread(() -> {
            System.out.println("Th1 started");
            try {

                Thread.sleep(5000l);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Th1 Finished Task");
        });



        Thread th2 = new Thread(()-> {
            System.out.println("Thread 2 started");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 2 Finished");
        });


        th1.start();


        /*try {
            th1.join();
        }catch(Exception e){

        }*/
        th2.start();

        try {
            th2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main Thread finished "+ Thread.currentThread().getName());
    }
}
