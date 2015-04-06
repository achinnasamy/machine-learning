package com.dmac.async.messaging.concurrent;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.FutureTask;

import com.equator.common.constraints.Conditions;
import com.equator.common.constraints.annotations.NotNull;
import com.google.common.base.Function;

public class ParallelExecutor {

	
	public static void execute() {
		
//		FutureTask<IPROMessage> futureTask3 = new FutureTask<IPROMessage>(new Callable<IPROMessage>() {
//
//			@Override
//			public IPROMessage  call() throws Exception {
//				
//				List<IPROParticipant> listOfParticipants = new ArrayList<IPROParticipant>();
//				listOfParticipants.add(new IPROParticipant("PGAM26"));
//				listOfParticipants.add(new IPROParticipant("PGAM27"));
//				listOfParticipants.add(new IPROParticipant("PGAM28"));
//				listOfParticipants.add(new IPROParticipant("PGAM29"));
//				listOfParticipants.add(new IPROParticipant("PGAM20"));
//				
//				IPROMessage iproMessage = new IPROMessage("GAM2", "", "GAM2 -  ", listOfParticipants);
//						
//				IMessagingServiceProducer iMessagingServiceProducer = new RabbitMQMessagingServiceGroupProducer();		
//				iMessagingServiceProducer.send(iproMessage);
//				return iproMessage;
//			}
//            
//        });
//	
//		ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//		executor.execute(futureTask3);
//		executor.shutdown();
	}
	
	public static void main(String[] args) {
		ParallelExecutor.execute();
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
