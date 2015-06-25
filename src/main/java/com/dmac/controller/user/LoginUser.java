package com.dmac.controller.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dmac.rest.RestResponse;
import com.dmac.service.UsersService;

@Controller
@RequestMapping( value = "login" )
public class LoginUser 
{
	
	
	
	@Autowired
	public UsersService usersService;
	
	@RequestMapping(value="/loginUser/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String login(@PathVariable( "id" ) Long id) 
			
			
//			@RequestParam (value="loginName", required=false, defaultValue="alan") String loginName,
//						@RequestParam (value="password", required=false, defaultValue="turing") String password) 
	{
//		String cryptedPassword = usersService.fetchPassword("Boomerang");
//		
//		System.out.println("The Encrypted Password : " + cryptedPassword);
		
		
		System.out.println(id.intValue());
		return "SUCCESS";
	}

		
	@RequestMapping(value="/loginUserAuthentication/{id}", method = RequestMethod.GET)
	@ResponseBody
	public RestResponse loginUserAuthentication(@RequestParam (value="userName", required=false, defaultValue="alan") String userName) {
	
		System.out.println("UserName - " + userName);
		
		//String cryptedPassword = usersService.fetchPassword("Boomerang");
		//System.out.println("The Encrypted Password : " + cryptedPassword);
		
		Map<String, String> restMap = new HashMap<String, String>();
		restMap.put("aravindh", "priya");
		restMap.put("ammu", "karthik");
		restMap.put("aravindh", "priya");
		
		RestResponse restResponse = new RestResponse();
		restResponse.setKey("loginResponse");
		restResponse.setValue("Success");
		restResponse.setResponseMap(restMap);
		
		return restResponse;
	}
}
