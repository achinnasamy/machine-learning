package com.dmac.analytics.storm;


public class StormConnectionFactory {

	
	private static final StormConnectionFactory INSTANCE = new StormConnectionFactory().init();
	
	/**
	 * 
	 * @return
	 */
	public static StormConnectionFactory getInstance() {
		
		return INSTANCE;
	}
	
	private StormConnectionFactory init() 
	{
		return null;
	}
}
