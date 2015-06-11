package com.dmac.core;

import java.util.Objects;

public class DMACMain {

	private static final String STAR = "*******************************************************";
	
	public static void main(String[] args) {

		String STAR_LINE_START_ = String.format("%s \n %s \n %s", STAR, STAR, STAR);
		String STAR_LINE_END_ = String.format("%s \n %s \n %s", STAR, STAR, STAR);

		
		
		
		int totalNoOfCores = Runtime.getRuntime().availableProcessors();

		int nbThreads =  Thread.getAllStackTraces().keySet().size();
		
		System.out.println(STAR_LINE_START_);
		
	
		
		System.out.println("No of Cores : " + totalNoOfCores);
		Thread.getAllStackTraces().keySet()
													.forEach((z) -> System.out.println(z.getName() +" " + z.getThreadGroup().getName()));
		
		
		
		System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
		

		String detailedException = String.format("Exception ocurred due to %s. The root cause may also be %s.", "Dataflow Hinderance", "Regression Failure");
		System.out.println(detailedException);
		System.out.println(STAR_LINE_END_);
	}
}
