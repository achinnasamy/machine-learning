package com.dmac.server;

public enum JETTY_CODES {

	SERVER_PORT ("1982");
	
		
	
	private String jettyCodeName = "";
	
	
	
	public String getJettyCodeName() {
		return this.jettyCodeName;
	}



	private JETTY_CODES(String jettyCodeName_) {
		this.jettyCodeName = jettyCodeName_;
	}
}
