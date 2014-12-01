/**
 * 
 */
package com.dmac.messaging.messaging.producer;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import com.ipro.common.conditions.NotNull;
import com.ipro.messaging.function.IPROMessageToByteEncoderFunction;
import com.ipro.util.MessagingUtil;
import com.ipro.vo.IPROMessage;
import com.iprogames.util.constraints.Conditions;

/**
*
*
* @author <a href="mailto:aravindh.chinnasamy@mobax.com">Aravindh Chinnasamy</a>
* @version %I%, %G%
* @since AW
*/
public class KafkaMessagingServiceProducer implements IMessagingServiceProducer {

	
	public void send(@NotNull IPROMessage message) {		

		Conditions.checkNotNull(message);		
			
		Properties props = MessagingUtil.retrieveKafkaServerProducerConnectionProperties();
		
		ProducerConfig config = new ProducerConfig(props);		
		
		Producer<String, byte[]> producer = new Producer<String, byte[]>(config); 
	
		String queueTopicName = "";		
		
		if (message.isParticipantQueue()) {
			//queueTopicName = message.getParticipantID();
		}
		else
			queueTopicName = message.getGroupID();			
		
		byte[] bytes = new IPROMessageToByteEncoderFunction().encode(message);
		KeyedMessage<String, byte[]> data = new KeyedMessage<String, byte[]>(queueTopicName, bytes);
		
		producer.send(data);
		   
		producer.close();	    

	}
	

	
}
