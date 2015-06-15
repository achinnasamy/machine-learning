package com.dmac.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoyaltyRestService {

	@RequestMapping(value = "/retrieveLoyalties", method = RequestMethod.GET)
	@ResponseBody
	public String retrieveAllLoyalties() 
	{
		
		return "BALU";
	}

	@RequestMapping(value = "/retrieveGuna/guna/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public String retrieveGuna(@PathVariable String userId) 
	{
		System.out.println("Input Path Variable" + userId);
		return "GUNA";
	}
	
	
}
