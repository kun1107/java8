package com.practice.threads;

public class SharedResource {

    Boolean isItemAvailable = false;

    synchronized public void addItem(){

        isItemAvailable = true;
        System.out.println("Item Added by: "+Thread.currentThread().getName());
        notifyAll();
    }

    synchronized public void consumerItem() {
        System.out.println("Consumer Item method invoked by: "+ Thread.currentThread().getName());

        // using while loop to avoid spurious waking of thread
        while (!isItemAvailable){
            System.out.println("Thread "+Thread.currentThread().getName());
            try {
                System.out.println("Thread is waiting "+ Thread.currentThread().getName()+" now");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Item Consumed By: "+Thread.currentThread().getName());
        isItemAvailable = false;
    }
}
