package com.dmac.analytics.hbase;

public class IPROHBaseRuntimeException extends RuntimeException  {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @param messageKey
     */
    public IPROHBaseRuntimeException (String messageKey) {

        super (messageKey);

    }

    /**
     * @param messageKey
     * @param cause
     */
    public IPROHBaseRuntimeException (String    messageKey,
                                      Throwable cause) 
    {

        super (messageKey, cause);

    }
}
