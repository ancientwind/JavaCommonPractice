package com.multithread.sync;

public class ThreadLocalTest {

    private static void withoutThreadLocal() throws InterruptedException {

        Runnable counterRunnable = () -> {
            int counter = 0;
            System.out.println(Thread.currentThread().getName() + counter++);
        };

        Thread thread1 = new Thread(counterRunnable, "Thread1");
        Thread thread2 = new Thread(counterRunnable, "Thread2");
        thread1.start();
        thread2.start();
    }

    public void withoutThreadLocal2() {
        CounterRunnable counterRunnable = new CounterRunnable();
        Thread thread1 = new Thread(counterRunnable, "thread1");
        Thread thread2 = new Thread(counterRunnable, "thread2");
        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) throws InterruptedException {
       new ThreadLocalTest().withoutThreadLocal2();
    }

    class CounterRunnable implements Runnable {

        private int counter;
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + counter++);
        }
    }
}
