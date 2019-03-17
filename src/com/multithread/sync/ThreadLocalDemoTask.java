package com.multithread.sync;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class ThreadLocalDemoTask implements Runnable {

    // Atomic integer containing the next thread ID to be assigned
    private static final AtomicInteger nextId = new AtomicInteger(0);

    // Thread local variable containing each thread's ID
//    private static final ThreadLocal<Integer> threadId1 = new ThreadLocal<Integer>() {
//        @Override
//        protected Integer initialValue() {
//            return nextId.getAndIncrement();
//        }
//    };

    private static final ThreadLocal<Integer> threadId = ThreadLocal.withInitial(() -> nextId.getAndIncrement());

    // Returns the current thread's unique ID, assigning it if necessary
    public int getThreadId() {
        return threadId.get();
    }

    // Returns the current thread's starting timestamp
//    private static final ThreadLocal<Date> startDate = new ThreadLocal<Date>() {
//
//        @Override
//        protected Date initialValue() {
//            return new Date();
//        }
//    };

    private static final ThreadLocal<Date> startDate = new ThreadLocal<>();


    @Override
    public void run() {
        startDate.set(new Date());
        System.out.printf("Starting Thread: %s %s : %s\n", Thread.currentThread(), getThreadId(), startDate.get());
        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s %s : %s\n", Thread.currentThread(), getThreadId(), startDate.get());
    }

    public static void main(String[] args) {
        ThreadLocalDemoTask demoTask = new ThreadLocalDemoTask();
        Thread thread1 = new Thread(demoTask, "thread1");
        Thread thread2 = new Thread(demoTask, "thread2");
        thread1.start();
        thread2.start();
    }
}
