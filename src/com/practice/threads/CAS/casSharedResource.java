package com.practice.threads.CAS;

import java.util.concurrent.atomic.AtomicInteger;

public class casSharedResource {

    //int counter = 0;

    AtomicInteger counter = new AtomicInteger(0);

    public void increment(){
        //counter++;
        counter.incrementAndGet();
    }

    public int getCounter(){
        //return counter;
        return counter.get();
    }
}
