package com.multithread.threadPool;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        useExecutors();
    }

    private static void useExecutors() throws InterruptedException {
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

        System.out.println("time cost is: " + (endTime - startTime) / 1_000_000);
    }

    private static void useThreadPoolExecutor() {
        BlockingQueue<Runnable> worksQueue = new ArrayBlockingQueue<>(10);
        RejectedExecutionHandler executionHandler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println(r.toString() + " has been rejected! ");
            }
        };

        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5,
                5, TimeUnit.SECONDS, worksQueue, executionHandler);
        executor.execute(new WorkerThread(3));
        executor.shutdown();
    }

    public static void userThreadFacotry() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        singleThreadPool.execute(()-> System.out.println(Thread.currentThread().getName()));
        singleThreadPool.shutdown();
    }
}
