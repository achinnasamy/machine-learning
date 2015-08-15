package com.dmac.pig;

import java.io.IOException;

import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;

public class CustomerIDToNameMapperUDF extends EvalFunc<Tuple> {

	@Override
	public Tuple exec(Tuple input) throws IOException {
		
		
		String customerName 		= "";
		String typeOfCustomer = "";
		String timeStamp		=	"";
			  
		  
		Integer id = (Integer)input.get(0);
		timeStamp = (String)input.get(1);
		Float amount = (Float)input.get(2);
	
		if (amount > 100)
			typeOfCustomer = "HIGH_END_CUSTOMER";
		else
			typeOfCustomer = "LOW_END_CUSTOMER";
		
		if (id.intValue() == 11)
			customerName = "Aravindh";
		else if (id.intValue() == 8)
			customerName =  "Alan";
		else 
			customerName = "Turing";
		
		
		Tuple output = TupleFactory.getInstance().newTuple(3);
		output.set(0, customerName);
		output.set(1, timeStamp);
		output.set(2, typeOfCustomer);
		
		
		return output;
	}

}
