package com.dmac.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hdfs.DFSClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dmac.rest.RestResponse;

import java.net.URI;

@RestController
public class FileManagerResource {

	
	private static String hdfsUrl = "<your hdfs NameNode endpoint>";
	
	
	@RequestMapping(value="/uploadFileToHDFS", method = RequestMethod.GET)
	@ResponseBody
	public RestResponse uploadFileToHDFS(
				@RequestParam (value="fileName", required=true) String fileName)
	{
		
		Configuration conf = new Configuration();
        conf.set("fs.defaultFS", this.hdfsUrl);
        //DFSClient client = new DFSClient(new URI(this.hdfsUrl), conf);
        DFSClient client = null;
        OutputStream out = null;
        InputStream in = null;
                
        String destinationFilename = "";
        
        try {
            if (client.exists(fileName)) {
                System.out.println("File already exists in hdfs: " + destinationFilename);
                
                RestResponse restResponse = new RestResponse();
                restResponse.setErrorCode("1");
                restResponse.setErrorDescription("_FILE_ALREADY_EXISTS_");
                return restResponse;
            }
            out = new BufferedOutputStream(client.create(fileName, false));
            in = new BufferedInputStream(new FileInputStream(fileName));
            byte[] buffer = new byte[1024];
 
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
            
            client.close();
            in.close();
            out.close();
        }
        catch (IOException exception) {
        	
        }
		
		
		RestResponse restResponse = new RestResponse();
		return restResponse;
	}
	
	
	/**
	 * 
	 * @param directoryName
	 * @return
	 */
	@RequestMapping(value="/readFilesFromFileSystem", method = RequestMethod.GET)
	@ResponseBody
	public RestResponse readFilesFromFileSystem(
				@RequestParam (value="directoryName", required=true) String directoryName)
	{
		
		System.out.println("\n\n\n directoryName");
		
		RestResponse restResponse = new RestResponse();
		restResponse.setErrorCode("0");
		restResponse.setErrorDescription("SOME_ERROR_OCCURED");
		
		Map<String, String> restMap = new HashMap<String, String>();
		
        StringJoiner listOfFiles = new StringJoiner(":");
        
		Path path = FileSystems.getDefault().getPath("/Users/tester/dojo");
		
		
		try {
			Files.walkFileTree(path, new SimpleFileVisitor<Path>() {

				@Override
				public FileVisitResult visitFile(Path file,
						BasicFileAttributes attrs) throws IOException {
					
					listOfFiles.add(file.getFileName().toString());
					
					
					return FileVisitResult.CONTINUE;
				}
				
				
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		restMap.put("files", listOfFiles.toString());
		restResponse.setResponseMap(restMap);
		return restResponse;
	}
}



