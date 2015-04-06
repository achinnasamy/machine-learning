package com.dmac.async.messaging.producer;



import java.io.IOException;

import com.dmac.async.messaging.RABBITMQ_EXHANGE_TYPE;
import com.dmac.async.messaging.function.IPROMessageToByteEncoderFunction;
import com.dmac.async.vo.IPROMessage;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;

/**
*
*
* @author <a href="mailto:aravindh.chinnasamy@mobax.com">Aravindh Chinnasamy</a>
* @version %I%, %G%
* @since 1.0
*/
public class RabbitMQMessagingServiceGroupProducer extends AbstractRabbitMQMessagingServiceProducer {
	
	
	@Override
	public void send(IPROMessage message) {	
				
	
		try {
			
			Connection connection = retrieveConnectionToRabbitMQServer();
			Channel channel = connection.createChannel();

		    String topicName = message.getGroupID();	
		    
		    boolean durable = true;
		    //channel.exchangeDeclare(topicName, RABBITMQ_EXHANGE_TYPE.FANOUT.getName());    
		    channel.exchangeDeclare(topicName, RABBITMQ_EXHANGE_TYPE.FANOUT.getName(), durable);
		    
		    byte[] bytes = new IPROMessageToByteEncoderFunction().encode(message);
		    //channel.basicPublish(topicName, "", null, bytes);
		    channel.basicPublish(topicName, "", MessageProperties.PERSISTENT_TEXT_PLAIN, bytes);
		    
		    channel.close();
		    connection.close();
		    
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
	}

}
