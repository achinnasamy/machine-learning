package com.dmac.service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.util.Progressable;
import org.springframework.stereotype.Service;

@Service
public class HDFSService {

	/**
	 * 
	 * @param fileName
	 * @return success or failure
	 */
	public boolean createHDFSFile(String fileName) {
		return true;
	}

	/**
	 * 
	 * @param directoryName
	 * @return success or failure
	 */
	public boolean createHDFSDirectory(String directoryName) {
		return true;
	}
	
	/**
	 * 
	 * @param fileName
	 * @return success or failure
	 */
	public boolean copyFileFromLocalToHDFS(String fileName) {
		return true;
	}
	
	/**
	 * 
	 * @param completeFileNamePath
	 * @param directoryName
	 * @return success or failure
	 */
	public boolean uploadFileToHDFS(String completeFileNamePath, String directoryName) 
	{
		
		
		Configuration configuration = new Configuration();
		
		BufferedReader inputStream =null ;
		
		try {
			 inputStream = new BufferedReader(new FileReader("xanadu.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			FileSystem hdfs = FileSystem.get( new URI( "hdfs://localhost:54310" ), configuration );
			Path file = new Path("hdfs://localhost:54310/s2013/batch/table.html");
			
			if ( hdfs.exists( file )) 
			{ hdfs.delete( file, true ); } 
			
			
			OutputStream os = hdfs.create( file,
				    new Progressable() {
						
						@Override
						public void progress() {
							
							
						}
					});
			
				BufferedWriter br = new BufferedWriter( new OutputStreamWriter( os, "UTF-8" ) );
			
				String line = null;
			    while ((line = inputStream.readLine()) != null) {
			    	br.write(line);
			    }
		    
				
				br.close();
				hdfs.close();
				
				
			
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

}
