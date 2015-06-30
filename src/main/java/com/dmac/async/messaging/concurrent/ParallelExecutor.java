package com.dmac.async.messaging.concurrent;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

import com.equator.common.constraints.Conditions;
import com.equator.common.constraints.annotations.NotNull;
import com.google.common.base.Function;

public class ParallelExecutor {

		
	public static void main(String[] args) {
		
		List<String> listOfStrings = new ArrayList<String>();
		listOfStrings.add("Relevance");
		listOfStrings.add("lab");
		listOfStrings.add("does");
		listOfStrings.add("good");
		listOfStrings.add("on");
		listOfStrings.add("scholastic");
		listOfStrings.add("products");
		listOfStrings.add("and");
		listOfStrings.add("also");
		listOfStrings.add("in");
		listOfStrings.add("Dev");
		listOfStrings.add("Ops");
		listOfStrings.add("with");
		listOfStrings.add("RL");
		listOfStrings.add("Catalyst");
		listOfStrings.add("Product");
		
		List<String> outList = ParallelExecutor.transform(listOfStrings, new StringAppenderFunction());
		
		outList.forEach((myValues) -> System.out.println(myValues));
	}
	
	 public static <X, Y> List<Y> transform (@NotNull final List<X> inputList,
             								 @NotNull final Function<X, Y> function) 
             
     {

			Conditions.checkNotNull (inputList);
			Conditions.checkNotNull (function);
			
			if (inputList.isEmpty ()) {
			return Collections.EMPTY_LIST;
			}
			
			final ForkJoinPool                  forkJoinExecutor = new ForkJoinPool (Runtime.getRuntime().availableProcessors());
			final Object[]                      destination      = new Object[inputList.size ()];
			
			final MorphingRecursiveExecutor<X, Y> action           = new MorphingRecursiveExecutor<> (inputList,
			                                                                   destination,
			                                                                   function,
			                                                                   0,
			                                                                   inputList.size () - 1);
			
			forkJoinExecutor.invoke (action);
			
			final List<Y> resultList = new ArrayList (destination.length);
			
			for (final Object o : destination) {
				@SuppressWarnings ("unchecked") final Y y = (Y) o;			
				resultList.add (y);
			}

	  return resultList;
	  
     }

}

class StringAppenderFunction implements Function<String, String> {

	@Override
	public String apply(String inputString) {
		return inputString.concat(" - output appended string");
	}
}
