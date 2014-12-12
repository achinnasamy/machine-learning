package com.dmac.async.messaging.producer;



import com.dmac.async.vo.IPROMessage;



/**
*
*
* @author <a href="mailto:aravindh.chinnasamy@gmail.com">Aravindh Chinnasamy</a>
* @version %I%, %G%
* @since 1.0
*/
public interface IMessagingServiceProducer {
	
	public void send(IPROMessage message);
	
}
