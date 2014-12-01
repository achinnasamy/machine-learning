package com.dmac.messaging.common;

/**
* 
* @author <a href="mailto:aravindh.chinnasamy@mobax.com">Aravindh Chinnasamy</a>
* @version %I%, %G%
* @since 1.0
*/
public class RabbitMQDataFlowException extends RuntimeException  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @param messageKey
     */
    public RabbitMQDataFlowException (String messageKey) {

        super (messageKey);

    }

    /**
     * @param messageKey
     * @param cause
     */
    public RabbitMQDataFlowException (String    messageKey,
                                      Throwable cause) 
    {

        super (messageKey, cause);

    }
}
