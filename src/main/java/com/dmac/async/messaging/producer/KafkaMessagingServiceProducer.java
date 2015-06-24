package com.dmac.async.messaging.producer;



import java.util.Properties;

import com.dmac.async.messaging.function.IPROMessageToByteEncoderFunction;
import com.dmac.async.util.MessagingUtil;
import com.dmac.async.vo.IPROMessage;
import com.equator.common.constraints.Conditions;
import com.equator.common.constraints.annotations.NotNull;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;


/**
*
*
* @author <a href="mailto:aravindh.chinnasamy@gmail.com">Aravindh Chinnasamy</a>
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
