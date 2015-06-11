package com.dmac.rest;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/loyalty")
public class LoyaltyRestService {

	public Loyalty retrieveAllLoyalties() 
	{
		return new Loyalty();
	}
}
