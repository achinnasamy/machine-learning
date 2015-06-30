package com.dmac.file;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/commonFileUpload")
@MultipartConfig	(fileSizeThreshold=1024*1024*2, // 2MB
					 maxFileSize=1024*1024*10,      // 10MB
					 maxRequestSize=1024*1024*50)   // 50MB

public class CommonFileUploadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response)
		throws ServletException, IOException {
		
		for (Part part : request.getParts()) {
            String fileName = "/Users/tester/myfile.csv";
            part.write("/Users/tester/del/" + File.separator + fileName);
        }
		
		System.out.println("\n\n\n File Uploaded Successfully \n\n\n");
		
	}
	
	
	

}
