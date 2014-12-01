package com.dmac.messaging.util;

import java.util.Properties;

import kafka.consumer.ConsumerConfig;

/**
*
*
* @author <a href="mailto:aravindh.chinnasamy@mobax.com">Aravindh Chinnasamy</a>
* @version %I%, %G%
* @since 1.0
*/
public final class MessagingUtil {

	private MessagingUtil() {}
	
	public final static Properties retrieveKafkaServerProducerConnectionProperties() 
	{		
		Properties props = new Properties();
		props.put("zk.connect", "127.0.0.1:2181");
		props.put("serializer.class", "kafka.serializer.DefaultEncoder");
		props.put("metadata.broker.list", "localhost:9092");
		
		return props;
	}
	
	public final static ConsumerConfig retrieveKafkaConsumerConfig() {
        
		Properties props = new Properties();
        props.put("zookeeper.connect", "127.0.0.1:2181");
        props.put("group.id", "console-consumer-25366");
        props.put("zookeeper.session.timeout.ms", "400");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.commit.interval.ms", "1000");
 
        return new ConsumerConfig(props);
    }
}
