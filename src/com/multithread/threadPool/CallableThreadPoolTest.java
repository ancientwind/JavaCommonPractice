package com.multithread.threadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableThreadPoolTest {

    public static void main(String[] args) {
        int numWorkers = 3;

        ExecutorService pool = Executors.newCachedThreadPool();
        CallableWorkerThread workers[] = new CallableWorkerThread[numWorkers];
        Future[] futures = new Future[numWorkers];

        for (int i = 0; i < numWorkers; ++i) {
            workers[i] = new CallableWorkerThread(i + 1);
            futures[i] = pool.submit(workers[i]);
        }
        for (int i = 0; i < numWorkers; ++i) {
            try {
                System.out.println(futures[i].get() + " ended");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } catch (ExecutionException ex) {
                ex.printStackTrace();
            }
        }
    }
}
