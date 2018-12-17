package com.ciandt.challenge.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ciandt.challenge.business.AcceleratorBusiness;
import com.ciandt.challenge.vo.AcceleratorInputRequest;

@RestController
public class AcceleratorController {

	@Autowired
	private AcceleratorBusiness business;
	
	@RequestMapping(value = "/challenge/accelerator", produces = APPLICATION_JSON_UTF8_VALUE, method = POST)
	@ResponseBody
	public String accelerator(@RequestBody AcceleratorInputRequest input) throws Exception {
		
		return business.process(input);
	}
}