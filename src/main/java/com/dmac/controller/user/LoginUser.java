package com.dmac.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dmac.service.UsersService;

@RestController
public class LoginUser 
{
	@Autowired
	public UsersService usersService;
	
	@RequestMapping("/loginUser")
	public String login(@RequestParam (value="loginName", required=false, defaultValue="alan") String loginName,
						@RequestParam (value="password", required=false, defaultValue="turing") String password) 
	{
		String cryptedPassword = usersService.fetchPassword("Boomerang");
		
		System.out.println("The Encrypted Password : " + cryptedPassword);
		return "SUCCESS";
	}

	public UsersService getUsersService() {
		return usersService;
	}


	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
	
	
}
