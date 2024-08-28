package com.practice.threads;

public class ConsumerTask implements Runnable {

    SharedResource sharedResource;

    public ConsumerTask(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }
    @Override
    public void run() {
        sharedResource.consumerItem();
    }
}
