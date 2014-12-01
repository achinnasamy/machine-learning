package com.dmac.messaging.client;

import com.dmac.messaging.messaging.producer.IMessagingServiceProducer;
import com.dmac.messaging.messaging.producer.RabbitMQMessagingServiceParticipantProducer;
import com.dmac.messaging.vo.IPROMessage;

public class MessageParticipantProducerClient {

	public static void main(String[] args) {
		
		IPROMessage participantMessage = new IPROMessage();
		participantMessage.setParticipantID("DEFAULT_QUEUE");
		participantMessage.setMessage("Message from participant 0099");
		
		IMessagingServiceProducer mp = new RabbitMQMessagingServiceParticipantProducer();		
		mp.send(participantMessage);		

	}

}
