package com.dmac.messaging.messaging.producer;

import com.ipro.vo.IPROMessage;

/**
*
*
* @author <a href="mailto:aravindh.chinnasamy@mobax.com">Aravindh Chinnasamy</a>
* @version %I%, %G%
* @since 1.0
*/
public interface IMessagingServiceProducer {
	
	public void send(IPROMessage message);
	
}
