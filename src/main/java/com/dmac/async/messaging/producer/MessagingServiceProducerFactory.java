package com.dmac.async.messaging.producer;

import com.dmac.async.client.MessagingServerType;
import com.equator.common.constraints.Conditions;
import com.equator.common.constraints.annotations.NotNull;





/**
*
*
* @author <a href="mailto:aravindh.chinnasamy@gmail.com">Aravindh Chinnasamy</a>
* @version %I%, %G%
* @since 1.0
*/
public class MessagingServiceProducerFactory {


	/**
	 * 
	 * @param messagingService
	 * @return IMessagingServiceProducer
	 */
	public IMessagingServiceProducer retrieveMessagingServiceProducer(@NotNull MessagingServerType messagingServerType) {
		
		IMessagingServiceProducer iMessagingServiceProducer = null;
		
		Conditions.checkNotNull(messagingServerType);
		
		if (messagingServerType.equals(MessagingServerType.KAFKA))
			iMessagingServiceProducer = new KafkaMessagingServiceProducer();
		else
			iMessagingServiceProducer = new RabbitMQMessagingServiceGroupProducer();
			
		return iMessagingServiceProducer;
			
	}
}
