package com.dmac.async.messaging.consumer;

import com.dmac.async.vo.IPROMessage;




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
