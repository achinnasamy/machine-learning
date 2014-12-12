package com.dmac.async.client;



import java.io.IOException;

import com.dmac.async.messaging.consumer.IMessagingServiceParticipantConsumer;
import com.dmac.async.messaging.consumer.RabbitMQMessagingParticipantConsumer;
import com.dmac.async.vo.IPROMessage;
import com.dmac.async.vo.IPROParticipant;


/**
*
*
* @author <a href="mailto:aravindh.chinnasamy@gmail.com">Aravindh Chinnasamy</a>
* @version %I%, %G%
* @since AW
*/
public class MessageParticipantConsumerClient {

	public static void main(String[] args) {	
		
		try {
			
			IMessagingServiceParticipantConsumer iMessagingServiceParticipantConsumer 
												= new RabbitMQMessagingParticipantConsumer();

			IPROParticipant iPROParticipant = new IPROParticipant();
			iPROParticipant.setParticipantID("DEFAULT_QUEUE");
			iMessagingServiceParticipantConsumer.bindToPartipantQueue(iPROParticipant);
			

			while (true) {
			IPROMessage message = iMessagingServiceParticipantConsumer.receiveMessage();
			
			System.out.println("ssss" + message.getMessage());
			}
			//iMessagingServiceParticipantConsumer.effaceParticipant();
			//iMessagingServiceParticipantConsumer.expungeParticipant();
			
		} catch (IOException | InterruptedException e) {
			System.out.println(e.getMessage());
		} 
		
	}

}
