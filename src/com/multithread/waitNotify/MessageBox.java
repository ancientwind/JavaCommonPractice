package com.multithread.waitNotify;

import java.time.Instant;

public class MessageBox {

    private String message;
    private boolean hasMessage;

    // producer
    public synchronized void putMessage(String msg) {
        while (hasMessage) {
            try {
                /**
                 *  tells the calling thread to give up the lock and go to sleep
                 *  until some other thread enters the same monitor and calls notify().
                 */
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        this.hasMessage = true;
        this.message = msg + " Put @ " + System.nanoTime();
        notify();

    }

    // consumer
    public synchronized String getMessage() {
        while (!hasMessage) {
            // no new message
            try {
                wait();  // release the lock of this object
            } catch (InterruptedException e) {
            }
        }
        // acquire the lock and continue
        hasMessage = false;
        notify();
        return message + " Get @ " + System.nanoTime();
    }
}
