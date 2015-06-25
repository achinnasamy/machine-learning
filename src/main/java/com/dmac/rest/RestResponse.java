package com.dmac.rest;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Chinnasamy
 *
 */
public class RestResponse {

	private String 					key 				=	"key";
	
	private String					value				=	"value";
	
	private String					errorCode			=	"0";
	
	private String					errorDescription	=	"NO_ERROR";
	
	private Map<String, String>		responseMap			=	new HashMap<String, String>();

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public Map<String, String> getResponseMap() {
		return responseMap;
	}

	public void setResponseMap(Map<String, String> responseMap) {
		this.responseMap = responseMap;
	}
	
}
