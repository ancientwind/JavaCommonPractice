package com.multithread.threadPool;

import java.util.concurrent.*;

public class CallableThreadPoolTest {

    public static void main(String[] args) {
        int numWorkers = 3;

        ExecutorService pool = Executors.newCachedThreadPool();
        CallableWorkerThread[] workers = new CallableWorkerThread[numWorkers];
        Future[] futures = new Future[numWorkers];

        for (int i = 0; i < numWorkers; ++i) {
            workers[i] = new CallableWorkerThread(i + 1);
            futures[i] = pool.submit(workers[i]);
        }
        for (int i = 0; i < numWorkers; ++i) {
            try {
                /**
                 * or use isDone() to check whether Callable task is finished or not
                 */
                System.out.println(futures[i].get(100, TimeUnit.MILLISECONDS) + " and task is done? " + futures[i].isDone());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } catch (ExecutionException ex) {
                ex.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
    }
}
