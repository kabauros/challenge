package com.ciandt.challenge.controller.test;



import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ciandt.challenge.business.DeliveryBusiness;
import com.ciandt.challenge.controllers.DeliveryController;
import com.ciandt.challenge.vo.DeliveryRoute;
import com.ciandt.challenge.vo.DeliveryRouteCalculateRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
public class DeliveryControllerTest {

	@InjectMocks
	private DeliveryController controller;
	
	@Mock
	private DeliveryBusiness business;
	
	private MockMvc mockMvc;
	
	private Gson gson;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.build();
		gson = new GsonBuilder()
                .disableHtmlEscaping()
                .create();
	}
	
	@Test
	public void testInsertSuccess() throws Exception {
		DeliveryRoute route  =  new DeliveryRoute();
		
		route.setId(1L);
		route.setOrigem("A");
		route.setDestino("D");
		route.setDistancia(BigDecimal.TEN);
		
		String json = gson.toJson(route, DeliveryRoute.class);
		
		
		mockMvc.perform(MockMvcRequestBuilders.post("/challenge/delivery/insert_route")
				.content(json)
				.header("Content-Type", "application/json"))
		.andExpect(status().isOk());
	}
	
	@Test
	public void testProcessSuccess() throws Exception {
		DeliveryRouteCalculateRequest request = new DeliveryRouteCalculateRequest();
		request.setOrigem("A");
		request.setDestino("D");
		request.setAutonomia(new BigDecimal("10"));
		request.setValorDoLitro(new BigDecimal("2.50"));
				
		String json = gson.toJson(request, DeliveryRouteCalculateRequest.class);
		
		
		mockMvc.perform(MockMvcRequestBuilders.post("/challenge/delivery/calculete_route")
				.content(json)
				.header("Content-Type", "application/json"))
		.andExpect(status().isOk());
	}
}
