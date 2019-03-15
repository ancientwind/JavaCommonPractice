package com.multithread.sync;

public class TestSyncCounter {

    public static void main(String[] args) {
        tryJoin();
    }

    private static void tryJoin() {
        Thread increment = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                SynchronizedCounter.increment();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "increment thread ");

        Thread decrement = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                SynchronizedCounter.decrement();
            }
        }, "decrement thread");

        increment.start();
        try {
            increment.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        decrement.start();
    }


    private static void tryYield() {
        Thread increment = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                SynchronizedCounter.increment();
                //                        Thread.sleep(5);
                Thread.yield();
            }
        }, "increment thread ");

        Thread decrement = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                SynchronizedCounter.decrement();
                //                        Thread.sleep(5);
                Thread.yield();
            }
        }, "decrement thread");

        increment.start();
        decrement.start();
    }
}
