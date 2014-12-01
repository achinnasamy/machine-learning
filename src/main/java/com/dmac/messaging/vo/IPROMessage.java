/**
 * Copyright (c) 2014 iPro,Inc. and its affiliates. All rights reserved.
 */
package com.dmac.messaging.vo;

import java.util.Collections;
import java.util.List;

/**
*
*
* @author <a href="mailto:aravindh.chinnasamy@mobax.com">Aravindh Chinnasamy</a>
* @version %I%, %G%
* @since 1.0
*/
public final class IPROMessage {
	
	private String 			groupID 					= "";
	
	private String 			consumerID					= "";
	
	private String 			participantID				= "";
		
	private String 			message						= "";

	private boolean 		isParticipantQueue			= false;	
	
	private List<IPROParticipant>	listOfParticipants	= Collections.emptyList();	
	
	
	public IPROMessage() {}
	
	public IPROMessage(String groupID, String consumerID, String message, boolean isParticipantQueue) {
		super();
		this.groupID = groupID;
		this.consumerID = consumerID;
		this.message = message;
		this.isParticipantQueue = isParticipantQueue;
	}

	
	public IPROMessage(String groupID, String consumerID, String message, List<IPROParticipant> listOfParticipants) {
		
		super();
		this.groupID = groupID;
		this.consumerID = consumerID;
		this.message = message;
		this.listOfParticipants = listOfParticipants;
	}

	
	
	public String getParticipantID() {
		return participantID;
	}

	public void setParticipantID(String participantID) {
		this.participantID = participantID;
	}

	public String getGroupID() {
		return groupID;
	}

	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}

	public String getConsumerID() {
		return consumerID;
	}

	public void setConsumerID(String consumerID) {
		this.consumerID = consumerID;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isParticipantQueue() {
		return isParticipantQueue;
	}

	public void setParticipantQueue(boolean isParticipantQueue) {
		this.isParticipantQueue = isParticipantQueue;
	}

	public List<IPROParticipant> getListOfParticipants() {
		return listOfParticipants;
	}

	public void setListOfParticipants(List<IPROParticipant> listOfParticipants) {
		this.listOfParticipants = listOfParticipants;
	}	
}
