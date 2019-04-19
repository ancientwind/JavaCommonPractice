package com.multithread.sync;

public class TestSyncCounterWithJoinYield {

    public static void main(String[] args) {
        tryYield();
    }

    private void trySyncMethod() {
        synchronized (this) {
            System.out.println("syc block");
        }

        String test = "hello sync";
        synchronized (test) {
            System.out.println(test + Thread.currentThread());
        }
    }

    private synchronized void sayHello() {
        System.out.println("Hello");
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
            /**
             * thread increment will join the main thread,
             * and main thread will wait increment to terminated, then run
             */
            increment.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        decrement.start();
    }

    /**
     * yield could not guarantee the wake up priority
     */
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
