
package com.dmac.async.client;

import com.dmac.async.messaging.consumer.IMessagingServiceConsumer;
import com.dmac.async.messaging.consumer.RabbitMQMessagingGroupConsumer;



/**
*
*
* @author <a href="mailto:aravindh.chinnasamy@mobax.com">Aravindh Chinnasamy</a>
* @version %I%, %G%
* @since 1.0
*/
public class MessageGroupConsumerClient {

	public static void main(String[] args) {
		
		IMessagingServiceConsumer iMessagingServiceConsumer = new RabbitMQMessagingGroupConsumer();
		iMessagingServiceConsumer.receive("GAM777");
		
	}

}

