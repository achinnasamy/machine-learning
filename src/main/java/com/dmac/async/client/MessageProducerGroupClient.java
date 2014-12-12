package com.dmac.async.client;



import java.util.ArrayList;
import java.util.List;

import com.dmac.async.messaging.producer.IMessagingServiceProducer;
import com.dmac.async.messaging.producer.RabbitMQMessagingServiceGroupProducer;
import com.dmac.async.vo.IPROMessage;
import com.dmac.async.vo.IPROParticipant;

/**
*
*
* @author <a href="mailto:aravindh.chinnasamy@gmail.com">Aravindh Chinnasamy</a>
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
