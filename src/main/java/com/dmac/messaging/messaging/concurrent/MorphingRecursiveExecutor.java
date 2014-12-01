package com.dmac.messaging.messaging.concurrent;

import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

import com.google.common.base.Function;
import com.ipro.common.conditions.NotNull;
import com.iprogames.util.constraints.Conditions;

final class MorphingRecursiveExecutor<X, Y> extends RecursiveAction {

	/**
	* Minimum size of a task to execute, without further decomposition.
	*/
	private static final int  MINIMUM_THRESHOLD = 10;
	
	/**
	* SerialVersionId.
	*/
	private static final long serialVersionUID  = -4652584674904888485L;
	
	//~--- fields -----------------------------------------------------------------------------------------------------
	
	private final Object[]                 destination;
	private final int                      end;
	private final transient  Function<X, Y> function;
	
	@NotNull
	private final List<X>                  list;
	private final int                      start;
	
	//~--- constructors -----------------------------------------------------------------------------------------------
	
	/**
	* @param list
	* @param destination
	* @param function
	* @param start
	* @param end
	*/
	public MorphingRecursiveExecutor (@NotNull final List<X> list,
	                            @NotNull final Object[] destination,
	                            @NotNull final Function<X, Y> function,
	                            final int start,
	                            final int end) {
	
	super ();
	
	Conditions.checkNotNull (list);
	Conditions.checkNotNull (destination);
	Conditions.checkNotNull (function);
	
	this.list        = list;
	this.start       = start;
	this.end         = end;
	this.destination = destination;
	this.function    = function;
	
	}
	
	//~--- methods ----------------------------------------------------------------------------------------------------
	
	@Override
	protected void compute () {
	
	final int bracketSize = (this.end - this.start);
	
	if (bracketSize < MINIMUM_THRESHOLD) {
	    this.computeFully ();
	} else {
	    final int                           middle        = this.start + (bracketSize / 2);
	    final MorphingRecursiveExecutor<X, Y> firstSubtask  = new MorphingRecursiveExecutor<> (this.list,
	                                                                                       this.destination,
	                                                                                       this.function,
	                                                                                       this.start,
	                                                                                       middle);
	    final MorphingRecursiveExecutor<X, Y> secondSubtask = new MorphingRecursiveExecutor<> (this.list,
	                                                                                       this.destination,
	                                                                                       this.function,
	                                                                                       middle + 1,
	                                                                                       this.end);
	
	    ForkJoinTask.invokeAll (firstSubtask,
	                            secondSubtask);
	
	}
	
	}
	
	/**
	* Do the computation directly.
	*/
	private void computeFully () {
	
	for (int i = this.start; i <= this.end; i++) {
	    final Y result = this.function.apply (this.list.get (i));
	
	    this.destination[i] = result;
	}
	
	}
}

