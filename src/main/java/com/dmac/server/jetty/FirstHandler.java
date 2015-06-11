package com.dmac.server.jetty;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class FirstHandler extends AbstractHandler {

	@Override
	public void handle(String arg0, 
					   Request arg1, 
					   HttpServletRequest baseRequest,
					   HttpServletResponse response) 
	throws IOException, ServletException 
	{
		response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>Hello World</h1>");
		//baseRequest.setAttribute("HANDLER", true);
	}

}
