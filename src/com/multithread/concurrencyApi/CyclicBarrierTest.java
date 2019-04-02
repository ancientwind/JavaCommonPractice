package com.multithread.concurrencyApi;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        int N = 8;

        /**
         * 3 parties in, all finished then go on; could be reused again
         */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("当前线程"+Thread.currentThread().getName());
        });

        IntStream intStream = IntStream.range(0, N);

        intStream.forEach( i -> new Writer(cyclicBarrier).start());
    }


    static class Writer extends Thread{
        private CyclicBarrier cyclicBarrier;
        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据...");
            try {
                Thread.sleep(2000);      //以睡眠来模拟写入数据操作
                System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch(BrokenBarrierException e){
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }
    }
}
