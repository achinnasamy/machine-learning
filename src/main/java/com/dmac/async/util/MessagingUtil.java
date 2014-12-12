/*
 * Copyright 2014 Chinnasamy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dmac.async.util;



import java.util.Properties;

import kafka.consumer.ConsumerConfig;

/**
*
*
* @author <a href="mailto:aravindh.chinnasamy@gmail.com">Aravindh Chinnasamy</a>
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
