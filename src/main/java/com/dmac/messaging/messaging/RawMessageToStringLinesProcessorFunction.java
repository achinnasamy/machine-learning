package com.dmac.messaging.messaging;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Function;

public class RawMessageToStringLinesProcessorFunction implements Function<String, List<String>>
{

	@Override
	public List<String> apply(String rawMessage) {
		
		List<String> stringLines = new ArrayList<String>();		
		String[] arrayOfLines = substringsBetween(rawMessage,"\"", "\"");
		
		for (int i = 0; i < arrayOfLines.length; i++)
			stringLines.add(arrayOfLines[i]);
		
		return stringLines;
	}
	
	
	public static void main(String[] args) {		
		
		String rawMessage = "\"12345 | 12,14,15,20,35\" \"12346 | 13,34,26,37,87\" \"12456 | 13,23,56,47,94\" \"12345 | 12,16,15,22,35\" \"12346 | 13,38,24,33,823\" \"12456 | 13,234,562,47,943\"";		
		new RawMessageToStringLinesProcessorFunction().apply(rawMessage);
	}

	
	private static String[] substringsBetween(String str, String open, String close) {
		 
		 int strLen = str.length();
         int closeLen = close.length();
         int openLen = open.length();
         List list = new ArrayList();
         int pos = 0;
         while (pos < (strLen - closeLen)) {
             int start = str.indexOf(open, pos);
             if (start < 0) {
                 break;
             }
             start += openLen;
             int end = str.indexOf(close, start);
             if (end < 0) {
                 break;
             }
             list.add(str.substring(start, end));
             pos = end + closeLen;
         }
         if (list.isEmpty()) {
             return null;
         } 
         return (String[]) list.toArray(new String [list.size()]);		 			 
    }
}
