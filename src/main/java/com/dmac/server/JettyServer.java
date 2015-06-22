package com.dmac.server;

import java.io.IOException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class JettyServer {

	private static int SERVER_PORT = Integer.parseInt(JETTY_CODES.SERVER_PORT.getJettyCodeName());
	
	private static Server server;
	
	public static void startServer() throws Exception {
		server = new Server(SERVER_PORT);
		
		//server.setHandler(new FirstHandler());
		
		server.setHandler(getServletContextHandler(getContext()));
		
		
		System.out.println(
							String.format(" \n\n\n\n\n\n\n   ************* STARTED JETTY SERVER ON PORT : %s ************* \n\n\n\n\n\n\n ",
										 Integer.toString(SERVER_PORT)
										 )
						  );
		
		server.start();
		
		server.join();
		
		
		
	}
	
	public static void stopServer() throws Exception {
		server.stop();
	}
	
	public static void main(String CHIN[]) throws Exception {
		
		JettyServer.startServer();
	}
	
	

	private static ServletContextHandler getServletContextHandler(WebApplicationContext context) 
	throws IOException {
		
        ServletContextHandler contextHandler = new ServletContextHandler();
        contextHandler.setErrorHandler(null);
        contextHandler.setContextPath("/");
        contextHandler.addServlet(new ServletHolder(new DispatcherServlet(context)), "/*");
        contextHandler.addEventListener(new ContextLoaderListener(context));
        //contextHandler.setResourceBase(new ClassPathResource("").getURI().toString());
        return contextHandler;
    }
	
	private static WebApplicationContext getContext() {
		
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("com.dmac.rest");
        context.getEnvironment().setDefaultProfiles("dev");
        return context;
        
	}
	
	
	
}
