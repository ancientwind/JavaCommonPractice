package com.multithread.waitNotify;

public class MessageBox {

    private String message;
    private boolean hasMessage;

    // producer
    public synchronized void putMessage(String msg) {
        while (hasMessage) {
            try {
                wait();
            }
            catch (InterruptedException e) {
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
            } catch (InterruptedException e) { }
        }
        // acquire the lock and continue
        hasMessage = false;
        notify();
        return message + " Get @ " + System.nanoTime();
    }
}
