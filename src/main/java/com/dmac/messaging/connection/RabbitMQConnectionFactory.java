package com.dmac.messaging.connection;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
*
* Singleton Connection Factory to RabbitMQ Messaging Service
*
* @author <a href="mailto:aravindh.chinnasamy@mobax.com">Aravindh Chinnasamy</a>
* @version %I%, %G%
* @since 1.0
*/
public final class RabbitMQConnectionFactory {	
	
	
	private static final 	String 							LOCAL_HOST 		= "localhost";	
	
	private static final 	RabbitMQConnectionFactory 		INSTANCE 		= new RabbitMQConnectionFactory();
	
	private static final 	ConnectionFactory 				factory 		= new ConnectionFactory();
	
	private static 			Connection 						connection 		= null;
	
	private RabbitMQConnectionFactory() {}
	
	/**
	 * Singleton Instance of the Factory
	 * 
	 * @return RabbitMQConnectionFactory
	 */
	public static RabbitMQConnectionFactory getInstance() {	
		return INSTANCE;
	}
	
	/**
	 * 
	 * @return
	 */
	public Connection getConnection() throws IOException  
	{		
		
		if (connection == null) 
		{			
		    factory.setHost(LOCAL_HOST);
		    connection = factory.newConnection();	    
	    }
		
		return connection;
	}
	
	/**
	 * 
	 * @return Channel
	 * @throws IOException
	 */
	public static Channel getChannel() throws IOException 
	{
		ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost(LOCAL_HOST);
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();
	    return channel;
	}
}
