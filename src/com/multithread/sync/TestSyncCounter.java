package com.multithread.sync;

public class TestSyncCounter {

    public static void main(String[] args) {

        Thread increment = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    SynchronizedCounter.increment();
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }
            }
        };

        Thread decrement = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    SynchronizedCounter.decrement();
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }
            }
        };

        increment.start();
        decrement.start();
    }
}
