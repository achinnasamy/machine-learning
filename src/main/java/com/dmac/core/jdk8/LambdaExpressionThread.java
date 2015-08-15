package com.dmac.core.jdk8;

public class LambdaExpressionThread {

	public static void main(String args[]) {
		
		Runnable runnable  = () -> {
		
			for (;;) {
				System.out.println("I am inside the thread");
			}
		};
		
		Runnable runnable_2  = () -> {
			
			for (;;) {
				System.out.println("I am inside the thread 2");
			}
		};
		
		new Thread(runnable).start();
		new Thread(runnable_2).start();
		//runnable_2.run();
		//runnable.run();
	}
}
