/**
 * Copyright (c) 2014 iPro,Inc. and its affiliates. All rights reserved.
 */
package com.dmac.messaging.client;

import java.util.ArrayList;
import java.util.List;

import com.dmac.messaging.messaging.producer.IMessagingServiceProducer;
import com.dmac.messaging.messaging.producer.RabbitMQMessagingServiceGroupProducer;
import com.dmac.messaging.vo.IPROMessage;
import com.dmac.messaging.vo.IPROParticipant;

/**
*
*
* @author <a href="mailto:aravindh.chinnasamy@mobax.com">Aravindh Chinnasamy</a>
* @version %I%, %G%
* @since AW
*/
public class MessageProducerGroupClient {

	public static void main(String[] args) {	

		System.out.println(" --- Sender Invoked --- ");
		List<IPROParticipant> listOfParticipants = new ArrayList<IPROParticipant>();
		listOfParticipants.add(new IPROParticipant("PGAM776"));
		listOfParticipants.add(new IPROParticipant("PGAM777"));
		listOfParticipants.add(new IPROParticipant("PGAM778"));
		listOfParticipants.add(new IPROParticipant("PGAM779"));
		listOfParticipants.add(new IPROParticipant("PGAM770"));
		
		IPROMessage iproMessage = new IPROMessage("GAM777", "", "Chin - Consumer sends in a message ", listOfParticipants);
				
		IMessagingServiceProducer iMessagingServiceProducer = new RabbitMQMessagingServiceGroupProducer();		
		iMessagingServiceProducer.send(iproMessage);
		
	}

}
