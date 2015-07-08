package com.dmac.controller;

import javax.ws.rs.FormParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dmac.rest.RestResponse;
import com.dmac.service.MachineLearningService;

@RestController
@RequestMapping(value="/v1/sparkReckoner")
public class SparkReckonerResource {

	@Autowired
	public MachineLearningService machineLearningService;
	
	@RequestMapping(value="/invokeLearning", method = RequestMethod.GET)
	@ResponseBody
	public RestResponse invokeLearning(
				@FormParam (value="algorithmName") String directoryName)
	{
		RestResponse restResponse = new RestResponse();
		return restResponse;
	}
}
