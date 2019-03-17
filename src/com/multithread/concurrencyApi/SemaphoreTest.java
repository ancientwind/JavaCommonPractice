package com.multithread.concurrencyApi;

import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class SemaphoreTest {

    private String name = "hello";

    public String getName() {
        synchronized (name) {
            return this.name;
        }
    }

    public void setName(String name){
        synchronized (name) {
            this.name = name;
        }
    }


    public static void main(String[] args) {
        int workers = 8;
        Semaphore semaphore = new Semaphore(5); // 5 threads totally

        IntStream.range(0, workers).forEach(
                i -> {
                    new Thread(new Worker(i, semaphore)).start();
                }
        );
    }

    static class Worker implements Runnable {

        private int num;
        private Semaphore semaphore;
        public Worker(int num,Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人"+this.num+"占用一个机器在生产...");
                Thread.sleep(1500);
                semaphore.release();
                System.out.println("工人"+this.num+"释放出机器");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
