package com.dmac.controller.user;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dmac.rest.RestResponse;
import com.dmac.service.UsersService;

@Controller
@RequestMapping( value = "v1/login" )
public class LoginUser 
{
	
	@Autowired
	public UsersService usersService;

	/**
	 * 
	 * 
	 * Success Login Response - {"key":"loginResponse","value":"success","errorCode":"0","errorDescription":"NO_ERROR","responseMap":{}}
	 * Failure Login Response - {"key":"loginResponse","value":"failure","errorCode":"0","errorDescription":"NO_ERROR","responseMap":{}}
	 * 
	 * @param userName
	 * @param password
	 * @return json
	 */
	@RequestMapping(value="/loginUserAuthentication", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse loginUserAuthentication(@RequestParam (value="userName", required=true) String userName,
												@RequestParam (value="password", required=true) String password) 
	{
	
		
		Objects.requireNonNull(userName, "userName null in loginUserAuthentication() of LoginUser component");
		Objects.requireNonNull(password, "password null in loginUserAuthentication() of LoginUser component");
		
		
		System.out.println("UserName - " + userName);
		
		//String cryptedPassword = usersService.fetchPassword("Boomerang");
		//System.out.println("The Encrypted Password : " + cryptedPassword);
		
		RestResponse restResponse = new RestResponse();
		
		if (userName.equals("boomerang") && password.equals("boomerang"))
		{	
			restResponse.setKey("loginResponse");
			restResponse.setValue("success");
		}
		else {
			restResponse.setKey("loginResponse");
			restResponse.setValue("failure");
		}
			
		return restResponse;
	}
}
