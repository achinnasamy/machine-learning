package com.dmac.core.jdk8;

public class DefaultMethodImpl implements DefaultMethod {

	@Override
	public String anInterfaceMethod() {
		
		return "Normal interface method";
	}

	
	
	public static void main(String args[]) {
		
		DefaultMethod defaultMethodObject = new DefaultMethodImpl();
		
		System.out.println(defaultMethodObject.anInterfaceMethod());
		
		defaultMethodObject.iamADefaultMethod();
		
		
		System.out.println(defaultMethodObject.defaultMethodWithAReturn("parameters_passed"));

	}
}
