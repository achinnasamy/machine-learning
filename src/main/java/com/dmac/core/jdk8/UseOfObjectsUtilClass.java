package com.dmac.core.jdk8;

import java.util.Objects;

public class UseOfObjectsUtilClass {

	private String name = "";
	
	

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void objectUtility(UseOfObjectsUtilClass utilObject_) {
		UseOfObjectsUtilClass utilObject = Objects.requireNonNull(utilObject_, 
												   "Object found null in method objectUtility of UseOfObjectsUtilClass");
		System.out.println(utilObject.getName());
	}
	
	public static void main(String RL[])
	{
		UseOfObjectsUtilClass utilObject = new UseOfObjectsUtilClass();
		utilObject.objectUtility(null);
	}
}
