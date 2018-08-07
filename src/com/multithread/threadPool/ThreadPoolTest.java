package com.multithread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        int numWorkers = 8;
        int threadPoolSize = 3;

        ExecutorService pool =
                Executors.newFixedThreadPool(threadPoolSize);
        WorkerThread[] workerThreads = new WorkerThread[numWorkers];

        long startTime = System.nanoTime();
        for (int i = 0; i < numWorkers; i++) {
            workerThreads[i] = new WorkerThread(i + 1);
            pool.execute(workerThreads[i]);
        }
        pool.shutdown(); // cause pool to reject new tasks
//        pool.shutdownNow(); //prevents waiting tasks from starting and attempts to stop currently executing tasks.
        pool.awaitTermination(1, TimeUnit.HOURS);
        long endTime = System.nanoTime();

        System.out.println("time cost is: " + (endTime - startTime) / 1000000);
    }
}
