package com.dmac.ml.knn;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;


public class LinearRegression {

	
	 public static void main(String[] args) {
		List<String> totalStrings = new ArrayList<String>();
		totalStrings.add("lambda");
		totalStrings.add("expresion");
		totalStrings.add("iteration");
		totalStrings.add("lambda");
		totalStrings.add("expresion");
		totalStrings.add("iteration");
		
		totalStrings.stream()
					.parallel()
					.forEach((z) -> new StringPrintFunction().apply(z) );
		
		
		
		
		
		
		Stream<String> str = totalStrings.parallelStream()
									 .filter((z) -> z.startsWith("l"))
									 .sorted().distinct();
		
		//str.forEach((z) -> System.out.println(z));
	}
	
}


class StringPrintFunction implements Function<String, String>
{

	@Override
	public String apply(String t) {
		System.out.println(t);
		return "a";
	}
	
}