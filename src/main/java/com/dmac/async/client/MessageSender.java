package com.dmac.async.client;



import java.util.ArrayList;
import java.util.List;

import com.dmac.async.messaging.RawMessageToStringLinesProcessorFunction;


public class MessageSender {

	
	final static String RAW_MESSAGE = "\"12345 | 12,14,15,20,35\" \"12346 | 13,34,26,37,87\" \"12456 | 13,23,56,47,94\" \"12345 | 12,16,15,22,35\" \"12346 | 13,38,24,33,823\" \"12456 | 13,234,562,47,943\"";
	
	public static void main(String[] args) {
		
		List<String> lines = new ArrayList<String>();
		RawMessageToStringLinesProcessorFunction function = new RawMessageToStringLinesProcessorFunction();
		
		System.out.println(lines.size());
		/*
		List<String> lines = function.apply(RAW_MESSAGE);
		
		for (String line : lines) {
			StringLineToIPROMessageProcessorFunction func = new StringLineToIPROMessageProcessorFunction();			
			IPROMessage message = func.apply(line);
			
		}*/
		 
		
	}

}
