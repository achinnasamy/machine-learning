package com.dmac.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dmac.db.PGSQLConnectionFactory;
import com.dmac.vector.GroupzDataVector;

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
	
	
	
	@RequestMapping(value = "/saveGroupzData/{groupzDataInput}", method = RequestMethod.GET)
	@ResponseBody
	public String saveGroupzData(@PathVariable String groupzDataInput) 
	{
		System.out.println("Input Path Variable" + groupzDataInput);
		return "GroupzDataSaved";
	}
	
	@RequestMapping(value = "/retrieveGroupzData/{machineID}/{memberID}", method = RequestMethod.GET)
	@ResponseBody
	public String retrieveGroupzData(@PathVariable String machineID,
									 @PathVariable String memberID) 
	{		
		GroupzDataVector gdv = new GroupzDataVector();
		gdv.setLicenceKey("102");
		gdv.setMachineID(machineID);
		gdv.setMemberID(memberID);
		gdv.setTimeZone("100");
		
		
		PGSQLConnectionFactory.getInstance().persistGroupzDataVector(gdv);

		return "OK-PERSISTED";
	}
}
