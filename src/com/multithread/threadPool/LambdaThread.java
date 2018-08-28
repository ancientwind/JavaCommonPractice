package com.multithread.threadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LambdaThread {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute( () -> {
            try {
                Thread.sleep(3*1000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });



        Future<String> future = executorService.submit( () -> {
            System.out.println("Future thread: could be cancel");
            Thread.sleep(2*1000);
            return "Hello Future";
        });

        try {
            System.out.println("Result got from Future: " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

//        executorService.shutdown(); // wait the sub thread to complete then shutdown it
//        executorService.shutdownNow();
        System.out.println("Main thread run");
        future.cancel(true);
    }
}
