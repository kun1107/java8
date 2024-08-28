package com.practice.threads.optimisticlock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {

    boolean isAvailable = true;
    public void producer(StampedLock lock){
       // long stamp = lock.readLock(); works same as read write lock
        long stamp = lock.tryOptimisticRead();
        System.out.println("Lock Acquired by Thread: " + Thread.currentThread().getName());
        try{
            if(lock.validate(stamp)) {
                System.out.println("update happen successfully");
                Thread.sleep(5000);
            }else{
                System.out.println("Some updated done by another Thread");
            }

        }catch (Exception e){

        }//finally { // not required for optimistic lock only required for readwrite lock
           // lock.unlock(stamp);
        //}
    }

    public void consumer(StampedLock lock){

        long stamp = lock.writeLock();
        System.out.println("Write lock acquired by thread: "+ Thread.currentThread().getName());
        try{
            isAvailable = false;
        }catch(Exception e){

        }finally {
            lock.unlockWrite(stamp);
            System.out.println("lock release by thread: "+ Thread.currentThread().getName());
        }
    }
}
