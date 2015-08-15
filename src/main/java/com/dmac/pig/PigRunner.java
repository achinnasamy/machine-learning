package com.dmac.pig;

import java.io.IOException;
import java.util.Properties;

import org.apache.pig.ExecType;
import org.apache.pig.PigServer;

public class PigRunner {

	
	public static void main(String[] args) {
		
		
		Properties props = new Properties();
		props.setProperty("fs.default.name", "hdfs://bdsa2:9000");
		props.setProperty("mapred.job.tracker", "bdsa2:8030");
		
		PigServer pigServer;
		
		try {
			pigServer = new PigServer(ExecType.MAPREDUCE, props);
			pigServer.registerScript("/home/bdsa/rfm.pig");
			pigServer.dumpSchema("rfm_data");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		


	}

}
