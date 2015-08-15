package com.dmac.core.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExpression {

	public static void main(String[] args) {
		
		List<String> countries = new ArrayList();
		countries.add("India");
		countries.add("Pakistan");
		countries.add("Srilanka");
		
		List<String> filteredListOfStrings = countries
												.parallelStream()
												.filter((z) -> z.startsWith("I"))
												.collect(Collectors.toList());
		filteredListOfStrings.stream().forEach(out -> System.out.println(out));
	}

}
