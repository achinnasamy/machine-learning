package com.dmac.async.messaging;



/**
*
*
* @author <a href="mailto:aravindh.chinnasamy@mobax.com">Aravindh Chinnasamy</a>
* @version %I%, %G%
* @since 1.0
*/
public enum RABBITMQ_EXHANGE_TYPE {

	TOPIC 			("topic"),
	FANOUT 			("fanout"),
	DIRECT 			("direct"),
	HEADERS 		("headers"),
	QUEUE			("");
	
	
	
	
	
	
	
	
	private String name = "";	
	
	private RABBITMQ_EXHANGE_TYPE(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
