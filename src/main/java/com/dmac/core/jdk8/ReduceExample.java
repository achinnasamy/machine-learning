package com.dmac.core.jdk8;

import java.util.stream.Stream;

public class ReduceExample {

	public static void main(String[] args) {
		

		int i = Stream.of(1,2,4)
					  .reduce(10, (acc,ele) -> acc+ele);
		
		System.out.println(i);
		
	}

}
