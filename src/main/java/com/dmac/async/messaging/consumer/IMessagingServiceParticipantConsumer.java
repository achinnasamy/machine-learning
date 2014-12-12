package com.dmac.async.messaging.consumer;



import java.io.IOException;

import com.dmac.async.common.RabbitMQDataFlowException;
import com.dmac.async.vo.IPROMessage;
import com.dmac.async.vo.IPROParticipant;
import com.sun.istack.internal.NotNull;

/**
*
*
* @author <a href="mailto:aravindh.chinnasamy@mobax.com">Aravindh Chinnasamy</a>
* @version %I%, %G%
* @since 1.0
*/
public interface IMessagingServiceParticipantConsumer {
	
	/**
	 * 
	 * The participant that needs to be binded to the queue
	 * 
	 * @param participant The IPROParticipant to be binded
	 */
	public void 		bindToPartipantQueue(@NotNull IPROParticipant participant) throws IOException, InterruptedException;
	
	/**
	 * 
	 * @param topicQueueName
	 * @return IPROMessage
	 */
	public IPROMessage 	receiveMessage() throws RabbitMQDataFlowException;
	
	/**
	 * Returns true if participant is bound to queue else returns false.
	 * 
	 * @param queueName
	 * @return boolean
	 */
	public boolean 		isParticipantBoundToQueue(String queueName);
	
	
	/**
	 * Unbind the participant from the queue and delete the queue
	 */
	public void			expungeParticipant() throws IOException; 		
	
	/**
	 * Unbind the participant
	 */
	public void 		effaceParticipant();
}
