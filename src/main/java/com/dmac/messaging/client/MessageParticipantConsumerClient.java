/**
 * Copyright (c) 2014 iPro,Inc. and its affiliates. All rights reserved.
 */
package com.dmac.messaging.client;

import java.io.IOException;

import com.dmac.messaging.messaging.consumer.IMessagingServiceParticipantConsumer;
import com.dmac.messaging.messaging.consumer.RabbitMQMessagingParticipantConsumer;
import com.dmac.messaging.vo.IPROMessage;
import com.dmac.messaging.vo.IPROParticipant;

/**
*
*
* @author <a href="mailto:aravindh.chinnasamy@mobax.com">Aravindh Chinnasamy</a>
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
