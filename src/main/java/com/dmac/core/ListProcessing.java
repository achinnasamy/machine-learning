package com.dmac.core;

import java.util.ArrayList;
import java.util.List;


public class ListProcessing {

	public static void main(String[] args) {
		
		List<String> oldList = new ArrayList<String>();
		oldList.add("1");
		oldList.add("2");
		oldList.add("3");
		
		List<String> newList = new ArrayList<String>();
		newList.add("3");
		newList.add("4");
		
		//oldList.removeAll(newList);
		newList.removeAll(oldList);
		
		//System.out.println(oldList);
		System.out.println(newList);
				
	}
}
