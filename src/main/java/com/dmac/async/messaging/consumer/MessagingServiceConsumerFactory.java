package com.dmac.async.messaging.consumer;

import com.dmac.async.client.MessagingServerType;
import com.dmac.messaging.messaging.consumer.RabbitMQMessagingGroupConsumer;



/**
*
*
* @author <a href="mailto:aravindh.chinnasamy@mobax.com">Aravindh Chinnasamy</a>
* @version %I%, %G%
* @since 1.0
*/
public class MessagingServiceConsumerFactory {

	/**
	 * 
	 * @param messagingServerType
	 * @return
	 */
	public IMessagingServiceConsumer retrieveMessagingServiceConsumer(@NotNull MessagingServerType messagingServerType) {
		
		IMessagingServiceConsumer iMessagingServiceConsumer = null;
		
		Conditions.checkNotNull(messagingServerType);
		
		if (messagingServerType.equals(MessagingServerType.KAFKA))
			//iMessagingServiceConsumer = new KafkaMessagingConsumer();
		//else
			iMessagingServiceConsumer = new RabbitMQMessagingGroupConsumer();
			
		return iMessagingServiceConsumer;
			
	}
}
