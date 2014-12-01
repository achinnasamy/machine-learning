/**
 * Copyright (c) 2014 iPro,Inc. and its affiliates. All rights reserved.
 */
package com.dmac.messaging.vo;

public class IPROParticipant {

	/** Unique ID for the each participant **/
	private String 			participantID				= "";
	
	/** **/
	private String 			participantMessage			= "";	

	public IPROParticipant() {}
	
	public IPROParticipant(String participantID) {
		super();
		this.participantID = participantID;		
	}

	/**
	 * Unique ID for the each participant. ID is used as the UNIQUE_QUEUE_NAME
	 * 
	 * @return String
	 */
	public String getParticipantID() {
		return participantID;
	}

	/**
	 * Unique ID for the each participant. ID is used as the UNIQUE_QUEUE_NAME
	 * 
	 * @param participantID
	 */
	public void setParticipantID(String participantID) {
		this.participantID = participantID;
	}

	public String getParticipantMessage() {
		return participantMessage;
	}

	public void setParticipantMessage(String participantMessage) {
		this.participantMessage = participantMessage;
	}	
	
	
	
}
