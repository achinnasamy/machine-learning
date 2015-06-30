package com.dmac.core.jdk8;

import java.util.function.Function;

public class FunctionalProgramming {

	
	public static void main(String args[]) {
		
		Organization org = new UsernameFetcherFunction()
										  .compose(new HeightToEmployeeFunction())
										  .andThen(new UsernameToOrganizationFunction())										  
										  .apply(new Height("10"));
										  
										  
										  
		System.out.println(org.getValue());			  
													
	}
}

class Organization {
	
	String value = "";

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}	
}

class Height {
	
	String value = "";

	public Height(String _value) {
		this.setValue(_value);
	}
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}	
}


class HeightToEmployeeFunction implements Function<Height, Integer> {

	@Override
	public Integer apply(Height height) {
		
		if (height.getValue().equals("10"))
			return new Integer(100);
		else 
			return new Integer(101);
	}
	
}


class UsernameFetcherFunction implements Function<Integer, String> {

	@Override
	public String apply(Integer userid) {
		
		if (userid.intValue() == 100)
			return "chinnasamy";
		else
			return "dhara";
	}
	
}

class UsernameToOrganizationFunction implements Function<String, Organization> {

	@Override
	public Organization apply(String username) {
		
		Organization org = new Organization();
		
		if (username.equals("chinnasamy"))
			org.setValue("Machine-Learning-Analytics-Department");
		else
			org.setValue("Big-Data-Department");
		return org;
	}
	
}