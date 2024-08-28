package com.practice.threads.ThreadPool;

import java.util.concurrent.*;

public class ThreadPoolTest {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,4,
                10, TimeUnit.SECONDS,new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(), new CustomRejectionHandler());

        //to use keep alive time parameter
        threadPoolExecutor.allowCoreThreadTimeOut(true);

        for(int i = 1;i<=7;i++){
            threadPoolExecutor.submit(() -> {

                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Task processed by: "+ Thread.currentThread().getName());

            });
        }

        threadPoolExecutor.shutdown();
    }

}

class CustomThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        Thread th = new Thread(r);
        th.setPriority(Thread.MAX_PRIORITY);
        th.setDaemon(false);
        return th;
    }
}

class CustomRejectionHandler implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

        System.out.println("Task Rejected: "+ executor.toString());

    }
}
