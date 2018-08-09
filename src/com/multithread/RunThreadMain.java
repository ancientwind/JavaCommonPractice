package com.multithread;

import com.util.PrintUtil;

public class RunThreadMain {

	public static void main(String[] args) {
		
		RunThreadMain main = new RunThreadMain();
		main.runRunnableDemo();
		Double a = 3.51212;
		Double b = 1004444.032434234;
		Double result;
		result = PrintUtil.multiply(a, b);
		PrintUtil.print(result);
	}
	
	public void runRunnableDemo() {
		RunnableDemo rd1 = new RunnableDemo();
		RunnableDemo rd2 = new RunnableDemo();

		rd1.start();
		rd2.start();

	}
}
