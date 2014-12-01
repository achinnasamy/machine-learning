package com.dmac.messaging.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Priority;

import com.dmac.messaging.connection.RabbitMQConnectionFactory;
import com.dmac.messaging.messaging.RABBITMQ_EXHANGE_TYPE;
import com.dmac.messaging.messaging.function.ByteToIPROMessageDecoderFunction;
import com.dmac.messaging.messaging.producer.IMessagingServiceProducer;
import com.dmac.messaging.messaging.producer.RabbitMQMessagingServiceParticipantProducer;
import com.dmac.messaging.vo.IPROMessage;
import com.dmac.messaging.vo.IPROParticipant;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.GetResponse;
import com.rabbitmq.client.QueueingConsumer;

public class MessageGroupTopicConsumerLoadTest {

	private static final String LOCAL_HOST = "localhost";
	
	private static int 				GROUP_NAME_NUMBER 							= 9;
	
	public static void main(String[] args) {
		
		
		if (args.length > 0) {
			int groupNameNumber = Integer.parseInt(args[0]);
			GROUP_NAME_NUMBER = groupNameNumber;
		}


		String topicConsumerName = String.format("GROUP_%s", GROUP_NAME_NUMBER);
				
		final MessageGroupTopicConsumerLoadTest mgc = new MessageGroupTopicConsumerLoadTest();
		mgc.setTopicQueueName(topicConsumerName);
		mgc.receive();		

	}
	
	
	private String topicQueueName = "";
	
	
	public String getTopicQueueName() {
		return topicQueueName;
	}

	public void setTopicQueueName(String topicQueueName) {
		this.topicQueueName = topicQueueName;
	}

	public void receive() {
		
		String TOPIC_NAME = this.topicQueueName;
		
		try {			
			Connection connection = RabbitMQConnectionFactory.getInstance().getConnection();
		    //Channel channel = retrieveConnectionToRabbitMQServer();
			
			Channel channel = connection.createChannel();
			
		    
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
		      
		      
		      PrintWriter pw = new PrintWriter("/home/aravinth/" + topicQueueName);
		      pw.println("Message - " + iproMessage.getMessage());
		      pw.close();
		      
		      //publishMessageToParticipants(iproMessage);
		      
		      /** Acknowledge for every message to the producer for SURE data delivery **/ 
		      channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
		    }
	    
		} catch (IOException | InterruptedException e ) {
			System.out.println(e.getMessage());
		}

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

	private Channel retrieveConnectionToRabbitMQServer() throws IOException {
		
		ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost(LOCAL_HOST);
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();
	    
	    return channel;
	}
}
