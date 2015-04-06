package com.dmac.async.messaging.producer;



import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.dmac.async.messaging.function.IPROMessageToByteEncoderFunction;
import com.dmac.async.vo.IPROMessage;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;



public class RabbitMQMessagingServiceParticipantProducer  extends AbstractRabbitMQMessagingServiceProducer{

	
	private final static long QUEUE_EXPIRY_TIME = 100000;
	
	@Override
	public void send(IPROMessage message) {	
				
		
	
		try {
			
			Connection connection = retrieveConnectionToRabbitMQServer();
			Channel channel = connection.createChannel();
			
			String queueName = message.getParticipantID();		 
			
			/** Make the message durable, as we persist the messaging contents before sending */
			boolean durable = true;
			//channel.queueDeclare(queueName, false, false, false, null);
			
			// Queue lives for 10 minues
			Map<String, Object> args = new HashMap<String, Object>();
			args.put("x-expires", 600000);			
			
			channel.queueDeclare(queueName, durable, false, false, null);
			
		    
		    byte[] bytes = new IPROMessageToByteEncoderFunction().encode(message);
		    //channel.basicPublish("", queueName, null, bytes);
		    channel.basicPublish("", queueName, MessageProperties.PERSISTENT_TEXT_PLAIN, bytes);
		    
		    
		    channel.close();
		    connection.close();
		    
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
	}

}
