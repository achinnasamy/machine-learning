package com.dmac.analytics.storm;

public class IPROStormRuntimeException extends RuntimeException  {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @param messageKey
     */
    public IPROStormRuntimeException (String messageKey) {

        super (messageKey);

    }

    /**
     * @param messageKey
     * @param cause
     */
    public IPROStormRuntimeException (String    messageKey,
                                      Throwable cause) 
    {

        super (messageKey, cause);

    }
}
