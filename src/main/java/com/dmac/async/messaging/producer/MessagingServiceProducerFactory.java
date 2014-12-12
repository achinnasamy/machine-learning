package com.dmac.messaging.messaging.producer;

import com.ipro.client.MessagingServerType;
import com.ipro.common.conditions.NotNull;
import com.iprogames.util.constraints.Conditions;

/**
*
*
* @author <a href="mailto:aravindh.chinnasamy@mobax.com">Aravindh Chinnasamy</a>
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
