/**
 * Copyright (c) 2014 iPro,Inc. and its affiliates. All rights reserved.
 */
package com.dmac.messaging.client;

import com.dmac.messaging.messaging.consumer.IMessagingServiceConsumer;
import com.dmac.messaging.messaging.consumer.RabbitMQMessagingGroupConsumer;

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

