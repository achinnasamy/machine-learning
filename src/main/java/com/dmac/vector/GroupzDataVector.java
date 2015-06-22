package com.dmac.vector;

import java.time.LocalDateTime;



public final class GroupzDataVector {

	
	private String				licenceKey		=	"";
	
	private String 				machineID		= 	"";
	
	private String 				memberID		=	"";
	
	private LocalDateTime		timeStamp		= 	LocalDateTime.now();
	
	private String				timeFormat		=	"";
	
	private String				timeZone		=	"";
	
	
	private String				extendedData	=	"";

	public String getLicenceKey() {
		return licenceKey;
	}

	public void setLicenceKey(String licenceKey) {
		this.licenceKey = licenceKey;
	}

	public String getMachineID() {
		return machineID;
	}

	public void setMachineID(String machineID) {
		this.machineID = machineID;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getTimeFormat() {
		return timeFormat;
	}

	public void setTimeFormat(String timeFormat) {
		this.timeFormat = timeFormat;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getExtendedData() {
		return extendedData;
	}

	public void setExtendedData(String extendedData) {
		this.extendedData = extendedData;
	}
	
	
	
	
}
