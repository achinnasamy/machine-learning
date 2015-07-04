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
			
			String fileName = extractFileName(part);
			part.write("/Users/tester/dojo/" + File.separator + fileName);
			
        }
		
		System.out.println("\n\n\n File Uploaded Successfully \n\n\n");
		response.sendRedirect("http://localhost:8080/dmac-machine-learning-1.0-SNAPSHOT/dashboard/pages/projects.html");
	}	
	
	/**
	 *  
	 * @param part
	 * @return Filename
	 */
	private static String extractFileName(Part part) {
	        String contentDisp = part.getHeader("content-disposition");
	        String[] items = contentDisp.split(";");
	        for (String s : items) {
	            if (s.trim().startsWith("filename")) {
	                return s.substring(s.indexOf("=") + 2, s.length()-1);
	            }
	        }
	        return "";
	 }

}
