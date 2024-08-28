package com.practice.threads.producerConsumer;

import java.util.Queue;

public class SharedResource {

    private Integer bufferSize;
    private Queue<Integer> sharedBuffer;

    public SharedResource(Integer bufferSize, Queue<Integer> sharedBuffer) {
        this.bufferSize = bufferSize;
        this.sharedBuffer = sharedBuffer;
    }

    synchronized public void producer(int item) throws InterruptedException {
        System.out.println("producer thread started");

        //Thread.sleep(5000);
        System.out.println("producer producing");
        while (sharedBuffer.size() == bufferSize){
            System.out.println("Shared buffer is full producer is waiting for consumer");
            wait();
        }

        sharedBuffer.add(item);
        System.out.println("Produced "+ item);
        notify();
    }

    synchronized public int consumer() throws InterruptedException {
        System.out.println("consumer thread started");

        while (sharedBuffer.size() == 0){
            System.out.println("consumer is waiting for producer");
            wait();
        }

        Integer item = sharedBuffer.poll();
        System.out.println("consumed "+ item);
        notify();
        return item;

    }
}
