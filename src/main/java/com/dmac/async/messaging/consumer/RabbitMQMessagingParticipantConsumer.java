package com.dmac.async.messaging.consumer;



import java.io.IOException;
import java.util.concurrent.ForkJoinPool;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;








import com.dmac.async.common.RabbitMQDataFlowException;
import com.dmac.async.messaging.function.ByteToIPROMessageDecoderFunction;
import com.dmac.async.vo.IPROMessage;
import com.dmac.async.vo.IPROParticipant;
import com.equator.common.constraints.Conditions;
import com.equator.common.constraints.annotations.NotNull;
import com.rabbitmq.client.AMQP.Queue.DeclareOk;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;

public class RabbitMQMessagingParticipantConsumer 
									extends AbstractRabbitMQMessagingParticipantConsumer 
{
	
	private static final Logger LOGGER 							= 
																	Logger.getLogger(RabbitMQMessagingParticipantConsumer.class);
	
	private IPROParticipant 	participant 					= null;	
	
	private Channel 			channel							= null;
		
	private IPROMessage			iproMessage 					= null;
	
	private boolean				shouldPariticipantBeUnbinded	= false;
		
	public IPROParticipant getParticipant() {
		return participant;
	}

	public void setParticipant(IPROParticipant participant) {
		this.participant = participant;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	

	public IPROMessage getIproMessage() {
		return iproMessage;
	}

	public void setIproMessage(IPROMessage iproMessage) {
		this.iproMessage = iproMessage;
	}
	
	
	public boolean isShouldPariticipantBeUnbinded() {
		return shouldPariticipantBeUnbinded;
	}

	public void setShouldPariticipantBeUnbinded(boolean shouldPariticipantBeUnbinded) {
		this.shouldPariticipantBeUnbinded = shouldPariticipantBeUnbinded;
	}

	public IPROMessage receive(@NotNull String topicQueueName) 
	{
		
		Conditions.checkNotNull(topicQueueName);		
		String participantQueueName = topicQueueName;
		
		try {			
		    Channel channel = retrieveConnectionToRabbitMQServer();
	
		    boolean durable = true;
		    channel.queueDeclare(participantQueueName, durable, false, false, null);
		    //channel.queueDeclare(participantQueueName, false, false, false, null);
		   	
		    String outString = String.format(" [*] Waiting for messages on Participant Queue %s . To exit press CTRL+C ", participantQueueName);
		    System.out.println(outString);
		    
		    QueueingConsumer consumer = new QueueingConsumer(channel);
		    
		    /** Making auto-acknowledge as false, as each message would be acknowledged after it has been consumed **/
		    boolean autoAcknowledge = false;
		    channel.basicConsume(participantQueueName, autoAcknowledge, consumer);
			    		    
		    while (true) {
		      QueueingConsumer.Delivery delivery = consumer.nextDelivery();
		      this.iproMessage = new ByteToIPROMessageDecoderFunction().decode(delivery.getBody());		
		      Thread.sleep(2000);
		      System.out.println("Message - " + iproMessage.getMessage());     
		      
		      /** Acknowledge for every message to the producer for SURE data consumption **/ 
		      channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
		    }
	    
		    
		} catch (IOException | InterruptedException e ) {
			LOGGER.log(Priority.DEBUG, e.getMessage());
		}
		
		return null;
	}

	@Override
	public void bindToPartipantQueue(IPROParticipant participant) throws IOException, 
																		 InterruptedException 
	{

		Conditions.checkNotNull(participant);		
		this.participant = participant;
		
		String participantQueueName = participant.getParticipantID();
	
	    channel = retrieveConnectionToRabbitMQServer();
	
	    boolean durable = true;
	    channel.queueDeclare(participantQueueName, durable, false, false, null);
	    //channel.queueDeclare(participantQueueName, false, false, false, null);
		   	
	    String outString = String.format(" [*] Waiting for messages on Participant Queue %s . To exit press CTRL+C ", participantQueueName);
	    System.out.println(outString);
		    
	    QueueingConsumer consumer = new QueueingConsumer(channel);
		    
	    /** Making auto-acknowledge as false, as each message would be acknowledged after it has been consumed **/
	    boolean autoAcknowledge = false;
	    channel.basicConsume(participantQueueName, autoAcknowledge, consumer);
	
		//ForkJoinPool fjp = new ForkJoinPool(2);
				
	    while (true) {
	    	
	      QueueingConsumer.Delivery delivery = consumer.nextDelivery();
	      this.iproMessage = new ByteToIPROMessageDecoderFunction().decode(delivery.getBody());		
		      
	      System.out.println("Message - " + iproMessage.getMessage());     
		      
	      /** Acknowledge for every message to the producer for SURE data consumption **/ 
	      channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);		 
		      
	      if (this.shouldPariticipantBeUnbinded)
	    	  break;
	    }

	}

	@Override
	public IPROMessage receiveMessage() throws RabbitMQDataFlowException {		
		return this.getIproMessage();
	}

	@Override
	public void expungeParticipant() throws IOException {		
		
		this.setShouldPariticipantBeUnbinded(true);
		
		String participantQueueName = participant.getParticipantID();		
		channel.queueDelete(participantQueueName);
        channel.close();		
	}

	@Override
	public void effaceParticipant() {
		this.setShouldPariticipantBeUnbinded(true);		
	}

	/**
	 * The queueDeclarePassive has to return DeclareOK. 
	 * If it throws a IOException then there is an issue with 
	 */
	@Override
	public boolean isParticipantBoundToQueue(String queueName) {
		
		try {
			DeclareOk returnOK = channel.queueDeclarePassive(queueName);
			
			if (returnOK != null)
				return true;
			
		} catch (IOException e) {
			
			LOGGER.log(Priority.DEBUG, e.getMessage());
			return false;
		}
		
		return false;
		
	}

}
