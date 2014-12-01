package com.dmac.messaging.messaging.consumer;

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
