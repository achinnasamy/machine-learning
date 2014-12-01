package com.dmac.messaging.messaging.consumer;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

import com.ipro.common.conditions.NotNull;
import com.ipro.messaging.RABBITMQ_EXHANGE_TYPE;
import com.ipro.messaging.function.ByteToIPROMessageDecoderFunction;
import com.ipro.messaging.producer.IMessagingServiceProducer;
import com.ipro.messaging.producer.RabbitMQMessagingServiceParticipantProducer;
import com.ipro.vo.IPROMessage;
import com.ipro.vo.IPROParticipant;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;

/**
*
*
* @author <a href="mailto:aravindh.chinnasamy@mobax.com">Aravindh Chinnasamy</a>
* @version %I%, %G%
* @since 1.0
*/
public class RabbitMQMessagingGroupConsumer extends AbstractRabbitMQMessagingConsumer {

	private static final Logger LOGGER = Logger.getLogger(RabbitMQMessagingGroupConsumer.class);
	
	@Override
	public IPROMessage receive(@NotNull String topicQueueName) 
	{
		String TOPIC_NAME = topicQueueName;
		
		try {			
		    Channel channel = retrieveConnectionToRabbitMQServer();
		    
		    boolean durable = true;
		    //channel.exchangeDeclare(TOPIC_NAME, RABBITMQ_EXHANGE_TYPE.FANOUT.getName());
		    channel.exchangeDeclare(TOPIC_NAME, RABBITMQ_EXHANGE_TYPE.FANOUT.getName(), durable);
		    
		    String queueName = channel.queueDeclare().getQueue();
		    
		    channel.queueBind(queueName, TOPIC_NAME, "");		

		    String outString = String.format(" [*] Waiting for messages on GROUP TOPIC %s . To exit press CTRL+C ", TOPIC_NAME);
		    System.out.println(outString);
		    
		    QueueingConsumer consumer = new QueueingConsumer(channel);
		    
		    /** Making auto-acknowledge as false, as each message would be acknowledged after it has been consumed **/
		    boolean autoAcknowledge = false;		    
		    channel.basicConsume(queueName, autoAcknowledge, consumer);
	
		    IPROMessage iproMessage = null;
		    
		    while (true) {
		      QueueingConsumer.Delivery delivery = consumer.nextDelivery();
		      iproMessage = new ByteToIPROMessageDecoderFunction().decode(delivery.getBody());
		      
		      System.out.println("Message - " + iproMessage.getMessage());		      
		      publishMessageToParticipants(iproMessage);
		      
		      /** Acknowledge for every message to the producer for SURE data delivery **/ 
		      channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
		    }
	    
		} catch (IOException | InterruptedException e ) {
			LOGGER.log(Priority.DEBUG, e.getMessage());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		try {
//			
//			ConnectionFactory factory = new ConnectionFactory();
//		    factory.setHost("localhost");
//		    Connection connection = factory.newConnection();
//		    Channel channel = connection.createChannel();
//	
//		    String topicName = topicQueueName;
//		    channel.exchangeDeclare(topicName, "fanout");
//		    
//		    String queueName = channel.queueDeclare().getQueue();
//		    
//		    channel.queueBind(queueName, arg1, arg2)
//			//channel.queueDeclare(topicQueueName, false, false, false, null);
//			
//		    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
//		    
//		    QueueingConsumer consumer = new QueueingConsumer(channel);
//		    channel.basicConsume(topicQueueName, true, consumer);
//	
//		    IPROMessage iproMessage = null;
//		    
//		    while (true) {
//		      QueueingConsumer.Delivery delivery = consumer.nextDelivery();
//		      iproMessage = new ByteToIPROMessageDecoderFunction().decode(delivery.getBody());
//		      
//		      System.out.println("Message - " + iproMessage.getMessage());
//		      
//		      if (isParticipant) {
//					System.out.println("Sending message to participant");
//					iproMessage.setParticipantQueue(true);
//					iproMessage.setMessage(iproMessage.getMessage() + " - participant modified the message");
//					
//					IMessagingServiceProducer mp = new RabbitMQMessagingServiceProducer();
//					mp.send(iproMessage);
//					//System.out.println("Sent");
//		      }
//		    }
//	    
//		} catch (IOException | InterruptedException e ) {
//			LOGGER.log(Priority.DEBUG, e.getMessage());
//		}
		
		return null;
	}
	
	
	private void publishMessageToParticipants(IPROMessage message) {
		
		List<IPROParticipant> participantList = message.getListOfParticipants();
		
		for (IPROParticipant ipoParticipant : participantList) {
			
			IPROMessage participantMessage = new IPROMessage();
			participantMessage.setParticipantID(ipoParticipant.getParticipantID());
			participantMessage.setMessage(message.getMessage() + " ******  " + ipoParticipant.getParticipantID() + " modified the message");
			
			IMessagingServiceProducer mp = new RabbitMQMessagingServiceParticipantProducer();		
			mp.send(participantMessage);		
		}
	}

}
