package com.dmac.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;
import org.springframework.stereotype.Service;

@Service
public class HDFSService {

	
	//private static String HDFS_PATH = "hdfs://ec2-52-24-58-38.us-west-2.compute.amazonaws.com:9000";
	private static String HDFS_PATH = "hdfs://localhost:9000";
		
	private Configuration configuration = new Configuration();
	
	
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
	public boolean createHDFSDirectory(String directoryName) throws IOException, URISyntaxException {
		
		Objects.requireNonNull(directoryName, "directoryName found null in createHDFSDirectory() method of HDFSService");
		
		String completeDirectoryName = "/".concat(directoryName);
		
		Path directory = new Path(completeDirectoryName);
		FileSystem hdfs = FileSystem.get( new URI( HDFS_PATH ), configuration );
		hdfs.create(directory);
		

		return true;
	}
	
	
	public List<String> listFilesFromHDFSDirectory(String directoryName) throws IOException, URISyntaxException {
		
		Objects.requireNonNull(directoryName, "directoryName found null in listFilesFromHDFSDirectory() method of HDFSService");
		
		String completeDirectoryName = "/".concat(directoryName);
		
		Path directory = new Path(completeDirectoryName);
		
		FileSystem hdfs = FileSystem.get( new URI( HDFS_PATH ), configuration );
		FileStatus[] files = hdfs.listStatus(directory);
		
		Path[] paths = FileUtil.stat2Paths(files);
		
		
		List<String> listOfFiles = new ArrayList<String>();
		
		Arrays.stream(paths)
			  .forEach(path -> listOfFiles.add(path.getName()));
		return listOfFiles;
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
	public boolean uploadFileToHDFS(String completeFileNamePath, String directoryName) throws IOException, URISyntaxException
	{
		
		
		
			Configuration conf = new Configuration();
			 
			BufferedReader inputStream =null ;
			
			try {
				 inputStream = new BufferedReader(new FileReader("/Users/tester/myfile.csv"));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		
			FileSystem hdfs = FileSystem.get( new URI( HDFS_PATH ), conf );
			Path file = new Path("/data/destination_file.csv");
			
			
			OutputStream os = hdfs.create( file);
			
			BufferedWriter br = new BufferedWriter( new OutputStreamWriter( os, "UTF-8" ) );
			
			String line = null;
			
			while ((line = inputStream.readLine()) != null) {
			    	br.write(line);
			}
		    
				
			br.close();
			hdfs.close();
				

			return true;
	}

	
	public static void main(String args[]) {
		
		System.setProperty("HADOOP_USER_NAME", "tester");  
		
		try {
			
//			UserGroupInformation ugi = 
//                    UserGroupInformation.createProxyUser("ubuntu", UserGroupInformation.getLoginUser());
//			
			//System.out.println(UserGroupInformation.getLoginUser().getGroupNames().length);
			//new HDFSService().createHDFSDirectory("hi");
			//new HDFSService().listFilesFromHDFSDirectory("");
			new HDFSService().uploadFileToHDFS("", "");
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}

	}
}
