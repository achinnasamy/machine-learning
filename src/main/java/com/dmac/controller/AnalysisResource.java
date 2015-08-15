package com.dmac.controller;

import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dmac.rest.RestResponse;

@RestController
@RequestMapping(value="/v1/analysisReckoner")
public class AnalysisResource {

	@RequestMapping(value="/retrieveAnalysisResults", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse retrieveAllAnalysisResults(
									@NotNull @FormParam (value="projectName") 	String projectName,
									@NotNull @FormParam (value="userName") 		String userName
									)
				
	{
		
		RestResponse restResponse = new RestResponse();
		
		
		return restResponse;
	}
}
