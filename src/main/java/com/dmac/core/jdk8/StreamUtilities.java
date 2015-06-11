package com.dmac.core.jdk8;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;




public class StreamUtilities {


	public void elucidatingMapMethod() {
		

		List<String> listArray = new ArrayList<String>();
		listArray.add("Arun");
		listArray.add("Varun");
		listArray.add("Saranya");
		
		List<String> modifiedArray = listArray.parallelStream().map(str->str.concat(" Rajamonikom"))
															   
								  							   .collect(toList());
		
		modifiedArray.forEach(z -> System.out.println(z));
	}
	
	
	public void elucidatingReduceMethod() {
		
		List<String> listArray = new ArrayList<String>();
		listArray.add("Arun");
		listArray.add("Aravindh");
		listArray.add("Varun");
		listArray.add("Saranya");
		
		long count = listArray.parallelStream()
							  .map(name -> name.startsWith("V"))
							  .collect(Collectors.toList())
							  .size();
								
		
		//System.out.println(count);
								  
													  
	}
	
	
	public void elucidatingTerminalMethod() {
		
	}
	
	
	public void useStringJoinMethod() {
		String joinedString = String.join(":", "SivaKumar", "Karthika", "Shanthi");
		
		System.out.println(joinedString);
	}
	
	public void use$w() {
		
	}
	
	public static void main(String[] args) {
		new StreamUtilities().useStringJoinMethod();

	}

}
