package com.dmac.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 * @author tester
 *
 */
public final class CommandLineUtil {

	private CommandLineUtil() { 	}
	
	public static List<String> runCommand(String command) throws IOException {
		
		Objects.requireNonNull(command, "command found null in runCommand() method of CommandLineUtil");
		
		List<String> outputList = new ArrayList<String>();
		
		Process process = executeCommand(command);
		InputStream inputStream = process.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedStream = new BufferedReader(inputStreamReader);
		String line = "";
	
		while ((line = bufferedStream.readLine()) != null) 
			outputList.add(line);
	
		return outputList;
	}
	
	public static Process executeCommand(String command) throws IOException {
		
		Objects.requireNonNull(command, "command found null in executeCommand() method of CommandLineUtil");
		
		Process process = Runtime.getRuntime().exec(command);

		return process;
	}
	
	
	public static void main(String args[]) {
		try {
			CommandLineUtil.runCommand("ls -lh /Users/tester/dojo/").forEach((z -> System.out.println(z)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
