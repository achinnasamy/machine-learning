package com.dmac.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginUser 
{

	@RequestMapping("loginUser")
	public String login(@RequestParam (value="loginName", required=false, defaultValue="alan") String loginName,
						@RequestParam (value="password", required=false, defaultValue="turing") String password) 
	{
		return "SUCCESS";
	}
}
