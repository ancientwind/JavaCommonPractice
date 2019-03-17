package com.multithread.concurrencyApi;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class LockTest {

    class PrinterQueue
    {
        private final Lock queueLock = new ReentrantLock();

        public void printJob(Object document)
        {
            queueLock.lock();
            try
            {
                Long duration = (long) (Math.random() * 10000);
                System.out.println(Thread.currentThread().getName() +
                        ": PrintQueue: Printing a Job during " + (duration / 1000) + " seconds :: Time - " + new Date());
                Thread.sleep(duration);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            } finally
            {
                System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
                queueLock.unlock();
            }
        }
    }

    class PrintingJob implements Runnable
    {
        private PrinterQueue printerQueue;

        public PrintingJob(PrinterQueue printerQueue)
        {
            this.printerQueue = printerQueue;
        }

        @Override
        public void run()
        {
            System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());
            printerQueue.printJob(new Object());
        }
    }

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        PrinterQueue printerQueue = lockTest.new PrinterQueue();

        Thread thread[] = new Thread[5];
        IntStream.range(0, 5).forEach( i -> {
            thread[i] = new Thread(lockTest.new PrintingJob(printerQueue));
        });

        for (int i = 0; i < 5; i++) {
            thread[i].start();
        }

    }
}
