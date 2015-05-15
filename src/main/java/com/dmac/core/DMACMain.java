package com.dmac.core;

public class DMACMain {

	private static final String STAR = "*******************************************************";
	
	public static void main(String[] args) {

		String STAR_LINE_START_ = String.format("%s \n %s \n %s", STAR, STAR, STAR);
		String STAR_LINE_END_ = String.format("%s \n %s \n %s", STAR, STAR, STAR);

		
		int totalNoOfCores = Runtime.getRuntime().availableProcessors();

		System.out.println(STAR_LINE_START_);
		
		System.out.println("No of Cores : " + totalNoOfCores);
		
		System.out.println(STAR_LINE_END_);
	}
}
