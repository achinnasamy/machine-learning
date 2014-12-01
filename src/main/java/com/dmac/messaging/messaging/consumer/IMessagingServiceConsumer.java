package com.dmac.messaging.messaging.consumer;

import com.ipro.common.conditions.NotNull;
import com.dmac.messaging.vo.IPROMessage;
import com.dmac.messaging.vo.IPROParticipant;

/**
*
*
* @author <a href="mailto:aravindh.chinnasamy@mobax.com">Aravindh Chinnasamy</a>
* @version %I%, %G%
* @since 1.0
*/
public interface IMessagingServiceConsumer {
	
	public IPROMessage receive(@NotNull String topicQueueName);
	
}
