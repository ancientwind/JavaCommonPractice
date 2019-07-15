package com.multithread;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicBoolean;

public class Interrupted {

	 public static void main(String[] args) throws InterruptedException {
        System.out.println("start get at: " + LocalDateTime.now());
        AtomicBoolean test = new AtomicBoolean(false);

        Thread thread1 = new Thread( () -> {
            int i = 0;
            while (!test.get()) {
                System.out.println(i++);
                if (i==5) {break;}
//                if (Thread.currentThread().isInterrupted()) {
//                    System.out.println("interrupted");
//                    break;}
                else {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("interrupted");
                        e.printStackTrace();
                        break;
                    }
                }
            }
        } );
        thread1.start();

        Thread.sleep(3200);
//        test.set(true);
        thread1.interrupt();
    }
}