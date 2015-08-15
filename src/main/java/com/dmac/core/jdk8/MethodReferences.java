package com.dmac.core.jdk8;

import java.util.List;
import java.util.stream.Collectors;

public class MethodReferences {

	public static void main(String[] args) {
		List<LatLong> latLongList = ListSource.retrieveList();
		
		List<String> namesUsingLambdaExpressions = latLongList.stream()
				.map(LatLong::getName)
				.collect(Collectors.toList());
		
		namesUsingLambdaExpressions.forEach(z -> System.out.println(z));
		
		List<String> namesUsingMethodReferences = latLongList.stream()
										.map(LatLong::getName)
										.collect(Collectors.toList());
		
		namesUsingMethodReferences.forEach(z -> System.out.println(z));

		
		latLongList.forEach(LatLong::printData);
		
	}

}
