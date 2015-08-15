package com.dmac.core.jdk8;

import java.util.List;
import java.util.function.Supplier;

public class JDK8Supplier {

	public static void main(String args[]) {
		
		Supplier<LatLong> supplier = LatLong::new;
		
		//Supplier<String> supplier1 = LatLong::getLatitude;
	}
}
