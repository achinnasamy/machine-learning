package com.dmac.async.messaging.admin;



import java.io.IOException;

import com.dmac.async.connection.RabbitMQConnectionFactory;
import com.rabbitmq.client.Connection;

public class RabbitMQAdministration {
		
	public static void main(String[] args) {
		
		try 
		{
			Connection connection = RabbitMQConnectionFactory.getInstance().getConnection();			
			System.out.println("Maximum Channels Allowed In the Connection : " + connection.getChannelMax());
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}	
	}
}