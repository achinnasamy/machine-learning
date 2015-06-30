package com.dmac.core.jdk8;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;




public class StreamUtilities {


	public void elucidatingMapMethod() {
		

		List<String> listArray = new ArrayList<String>();
		listArray.add("Arun");
		listArray.add("Varun");
		listArray.add("Saranya");
		
		List<String> modifiedArray = listArray.parallelStream().map(str->str.concat(" Labs"))
															   
								  							   .collect(toList());
		
		modifiedArray.forEach(z -> System.out.println(z));
		
		
		
		
		
		
		int[] lengthOfEachString = listArray.parallelStream()
											.mapToInt(str->str.length())											
											.toArray();
		
		for (int i : lengthOfEachString) {
			System.out.println(i);
		}
		
		
		OptionalDouble od = listArray.parallelStream()
				 					 .mapToInt(str->str.length())											
				 					 .average();
		
		System.out.println(od.getAsDouble());	
	}
	
	
	public void elucidatingTermialMethods() {
		
		List<String> listArray = new ArrayList<String>();
		listArray.add("Arun");
		
		listArray.add("Varun");
		listArray.add("Saranya");
		listArray.add("Aravindh");
		
		long count = listArray.parallelStream()
							  .filter(name -> name.startsWith("A"))
							  .count();
							  
								
		
		System.out.println(count);
								  
													  
	}
	
		
	
	public void useStringJoinMethod() {
		String joinedString = String.join(":", "Alan", "Turing", "Faraday");
		System.out.println(joinedString);
	}
	
	
	public static void main(String[] args) {
		new StreamUtilities().useStringJoinMethod();

		
		
	}

}
