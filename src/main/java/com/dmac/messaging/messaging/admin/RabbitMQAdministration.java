package com.dmac.messaging.messaging.admin;

import java.io.IOException;

import com.ipro.connection.RabbitMQConnectionFactory;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

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