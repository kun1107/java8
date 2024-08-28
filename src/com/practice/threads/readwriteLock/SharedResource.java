package com.practice.threads.readwriteLock;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResource {

    boolean isAvailable = true;

    public void producer(ReadWriteLock readWriteLock){
        try {
            readWriteLock.readLock().lock();
            System.out.println("Lock acquired by "+ Thread.currentThread().getName());
            System.out.println("Product Available "+ isAvailable);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            readWriteLock.readLock().unlock();
            System.out.println("Lock Released by Thread; "+ Thread.currentThread().getName());
        }
    }

    public void consumer(ReadWriteLock readWriteLock){
        try{
            readWriteLock.writeLock().lock();
            System.out.println("lock acquired by Thread: "+ Thread.currentThread().getName());

            isAvailable = false;

        }catch (Exception e){

        }finally {
            readWriteLock.writeLock().unlock();
            System.out.println("Lock Released by thread: "+ Thread.currentThread().getName());
        }
    }
}
