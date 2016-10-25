package com.multithread;

import com.util.Util;

/**
 * Create a Thread by Implementing a Runnable.
 * 
 * This idiom is more general, because the Runnable object can subclass other class.
 * Runnable task often be seperated from Thread object.
 * 
 * @author 212331901
 *
 */
public class RunnableDemo implements Runnable {

	private Thread t;
	private String threadName;
	public static int count;
	
	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	public void run() {
		Util.print("Running: " + this.getThreadName());
		
		for(int i = 4; i > 0; i--){
			Util.print("Thread: " + this.getThreadName() + ", at " + i);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Util.print("Thread: " + this.getThreadName() + " exiting.");
	}
	
	public void start() {
		if(this.getThreadName() == null || this.getThreadName().length() == 0)
			this.setThreadName("Thread-" + ++count );
		
		Util.print("Starting " + this.getThreadName());
		
		if(t == null) {
			t = new Thread(this, this.getThreadName());
			t.start();
		}
			
	}

}
