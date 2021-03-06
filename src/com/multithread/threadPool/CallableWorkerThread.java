package com.multithread.threadPool;

import java.util.concurrent.Callable;

public class CallableWorkerThread implements Callable<String> {

    private int workerNumber;

    CallableWorkerThread(int workerNumber) {
        this.workerNumber = workerNumber;
    }

    @Override
    public String call() {    // use call() instead of run()
        for (int i = 1; i <= 5; ++i) {    // just print 1 to 5
            System.out.printf("Worker-%d: count-%d\n", workerNumber, i);
            try {
                Thread.sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {}
        }
        return "worker " + workerNumber;
    }
}
