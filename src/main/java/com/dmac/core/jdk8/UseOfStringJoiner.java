package com.dmac.core.jdk8;

import java.util.StringJoiner;

public class UseOfStringJoiner {

	public static void main(String[] args) {
		StringJoiner listOfFiles = new StringJoiner(":", "[", "]");
		listOfFiles.add("shree.csv");
		listOfFiles.add("chin.csv");
		listOfFiles.add("arun.csv");
		
		System.out.println(listOfFiles.toString());
	}

}
