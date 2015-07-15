package com.dmac.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dmac.entity.Projects;
import com.dmac.rest.RestResponse;
import com.dmac.service.ProjectService;
import com.dmac.service.UsersService;

@RestController
@RequestMapping(value="/v1/projectReckoner")
public class ProjectReckonerResource {

	@Autowired
	public ProjectService projectService;
	
	@Autowired
	public UsersService usersService;
	
	
	/**
	 * 
	 * @param projectName
	 * @param userName
	 * @param projectSchema
	 * @return success : { key: "projectCreated" value: "success" errorCode: "0" errorDescription: "NO_ERROR" responseMap: { projectName: "chinnasamy" } }
	 */
	@RequestMapping(value="/createProject", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse createProject(
									@NotNull @FormParam (value="projectName") 	String projectName,
									@NotNull @FormParam (value="userName") 		String userName,
									@NotNull @FormParam (value="projectSchema") String projectSchema
									)
				
	{
		String userID = usersService.fetchUserID(userName);
		
		int userIDInt = Integer.parseInt(userID);
		
		boolean returnResponse = projectService.persistProject(projectName, userIDInt, projectSchema);
		RestResponse restResponse = new RestResponse();
		
		if (returnResponse) {
			
			restResponse.setKey("projectCreated");
			restResponse.setValue("success");
			
			Map<String, String> restMap = new HashMap<String, String>();
			restMap.put("projectName", projectName);
			
			restResponse.setResponseMap(restMap);
		}
		else {
			restResponse.setKey("projectCreated");
			restResponse.setValue("failure");
		}
		return restResponse;
	}
	
	
	
	@RequestMapping(value="/fetchProjects", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse fetchProjects(
									@NotNull @FormParam (value="userName") String userName
									)
				
	{
		
		List<Projects> listOfProjects = projectService.fetchAllProjects(userName);
		RestResponse restResponse = new RestResponse();
		
		if (listOfProjects == null) {			
			restResponse.setKey("projectRetrieval");
			restResponse.setValue("failure");
		}
		else {
			restResponse.setKey("projectRetrieval");
			restResponse.setValue("success");
		}
		return restResponse;
	}
}
