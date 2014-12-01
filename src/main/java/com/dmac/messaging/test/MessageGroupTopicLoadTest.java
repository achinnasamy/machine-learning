/**
 * Copyright (c) 2014 iPro,Inc. and its affiliates. All rights reserved.
 */
package com.dmac.messaging.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.dmac.messaging.messaging.producer.IMessagingServiceProducer;
import com.dmac.messaging.messaging.producer.RabbitMQMessagingServiceGroupProducer;
import com.dmac.messaging.vo.IPROMessage;
import com.dmac.messaging.vo.IPROParticipant;
import com.google.common.base.Stopwatch;

/**
*
*
* @author <a href="mailto:aravindh.chinnasamy@mobax.com">Aravindh Chinnasamy</a>
* @version %I%, %G%
* @since 1.0
*/
public class MessageGroupTopicLoadTest {

	
	private static int 				TOTAL_NUMBER_OF_GROUPS_TO_BE_CREATED  							= 10;
	
	
	public static void main(String[] args) {		
	
		if (args.length > 0) {
			int totalNumberOfGroups = Integer.parseInt(args[0]);
			TOTAL_NUMBER_OF_GROUPS_TO_BE_CREATED = totalNumberOfGroups;
		}
		
		System.out.println(" \n\n\n\n ******** The following floods the RabbitMQ with creating topics for the Group ******* \n\n\n\n ");
		
		final Stopwatch                                  watch    = Stopwatch.createStarted();
		
		for (int i = 1 ; i <= TOTAL_NUMBER_OF_GROUPS_TO_BE_CREATED; i++) 
		{
			
			String groupName 				= String.format("GROUP_%s", i);
			String participantName 			= String.format("PARTICIPANT_%s", i);
			String groupMessageName			= String.format("MESSAGE_FOR_GROUP_%s", i);
			
			List<IPROParticipant> listOfParticipants = new ArrayList<IPROParticipant>();
			listOfParticipants.add(new IPROParticipant(participantName));
			
			IPROMessage iproMessage = new IPROMessage(groupName, "", groupMessageName, listOfParticipants);					
			
			String outFormat = String.format(" \n\n ******** Group Topic %s created and message sent ******* \n\n ", groupName);
			System.out.println(outFormat);
			
			IMessagingServiceProducer iMessagingServiceProducer = new RabbitMQMessagingServiceGroupProducer();		
			iMessagingServiceProducer.send(iproMessage);
		}
		
		String outputMessage = String.format(" \n\n ******** %s Group Topics created in %s seconds ******* \n\n ", 
											TOTAL_NUMBER_OF_GROUPS_TO_BE_CREATED, 
											watch.elapsed(TimeUnit.SECONDS));
		System.out.println(outputMessage);
	}
}
