package com.multithread.threadPool;

import java.util.concurrent.ThreadFactory;

/**
 * @author 212331901
 * @date 2019/3/14
 */
public class ThreadFactoryBuilder implements ThreadFactory {

    private int counter = 1;
    private int priority = 10;

    @Override
    public Thread newThread(Runnable r) {

        Thread thread = new Thread(r, "Thread-" + counter++);
        thread.setPriority(nextPriority());
        return thread;
    }

    private int nextPriority() {
        int next = priority;
        priority--;
        priority = priority == 0 ? 10 : priority;
        return next;
    }

}
