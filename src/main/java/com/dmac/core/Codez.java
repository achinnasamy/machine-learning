package com.dmac.core;

public enum Codez {

	NO_VALUE					("NO_VALUE"),
	EMPTY_STRING				(""),
	SUCCESS						("SUCCESS"),
	FAILURE						("FAILURE");
	
	private String name;
	
	/**
	 * 
	 * @param name
	 */
	private Codez(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {		
		return this.name;
	}
}
