package com.dmac.core.jdk8;

public interface DefaultMethod {

	

	default public void iamADefaultMethod() {
		System.out.println("I am a default method");
	}
	

	String anInterfaceMethod();
	
	default String defaultMethodWithAReturn(String name) {
		
		String returnVal = "Make any complex business logic - " + name;	
		return returnVal;
	}
}
