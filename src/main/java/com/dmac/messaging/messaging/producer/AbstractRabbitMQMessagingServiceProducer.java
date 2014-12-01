package com.dmac.messaging.messaging.producer;

import java.io.IOException;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public abstract class AbstractRabbitMQMessagingServiceProducer  implements IMessagingServiceProducer {

private static final String LOCAL_HOST = "localhost";
	
	protected Connection retrieveConnectionToRabbitMQServer() throws IOException {
		
		ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost(LOCAL_HOST);
	    Connection connection = factory.newConnection();
	    
	    
	    return connection;
	}
}
