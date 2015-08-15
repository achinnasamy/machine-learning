package com.dmac.core.jdk8;

import java.util.function.Consumer;

public class JDK8Consumer {

	public static void main(String args[]) {
		Consumer<String> consumer = Company::setNasscomCode;
		consumer.accept("");
		
		
	}
	
}


class Company {
	
	private String nasscomCode = "";

	public String getNasscomCode() {
		return nasscomCode;
	}

	public static void setNasscomCode(String nasscomCode) {
		
	}
	
	
}