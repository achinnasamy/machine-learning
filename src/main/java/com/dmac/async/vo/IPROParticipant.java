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
package com.dmac.async.vo;

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
