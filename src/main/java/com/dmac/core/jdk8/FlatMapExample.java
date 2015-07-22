package com.dmac.core.jdk8;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FlatMapExample {

	public static void main(String[] args) {
		
		
		List<String> countries = new ArrayList();
		countries.add("India");
		countries.add("Pakistan");
		//countries.add(null);
		countries.add("");
		countries.add("Srilanka");
		
		List<String> cities = new ArrayList();
		cities.add("Bangalore");
		cities.add("Coimbatore");
		cities.add("");
		cities.add("Dhara");

		List<String> flattenedCountries = Stream.of(countries, cities)
												   .flatMap(z -> z.stream())
												   .collect(toList());

		flattenedCountries.forEach(z -> System.out.println(z));
		
		
	}

}
