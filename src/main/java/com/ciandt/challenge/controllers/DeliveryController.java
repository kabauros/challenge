package com.ciandt.challenge.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ciandt.challenge.business.DeliveryBusiness;
import com.ciandt.challenge.vo.DeliveryRoute;
import com.ciandt.challenge.vo.DeliveryRouteCalculateRequest;
import com.ciandt.challenge.vo.DeliveryRouteOutput;

@RestController
public class DeliveryController {
	
	@Autowired
	private DeliveryBusiness business;
	
	@RequestMapping(value = "/challenge/delivery/insert_route", produces = APPLICATION_JSON_UTF8_VALUE, method = POST)
	@ResponseBody
	public void insertRoute(@RequestBody DeliveryRoute route) {
		business.insertDeliveryRoutes(route);
	}
	
	
	@RequestMapping(value = "/challenge/delivery/calculete_route", produces = APPLICATION_JSON_UTF8_VALUE, method = POST)
	@ResponseBody
	public DeliveryRouteOutput calculateRoute(@RequestBody DeliveryRouteCalculateRequest route) throws Exception {
		return business.process(route);
	}
	
}
