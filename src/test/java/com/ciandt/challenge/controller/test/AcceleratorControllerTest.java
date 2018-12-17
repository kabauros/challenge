package com.ciandt.challenge.controller.test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ciandt.challenge.business.AcceleratorBusiness;
import com.ciandt.challenge.controllers.AcceleratorController;
import com.ciandt.challenge.vo.AcceleratorInputRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
public class AcceleratorControllerTest {

	@InjectMocks
	private AcceleratorController controller;
	
	@Mock
	private AcceleratorBusiness business;
	
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
	public void testAcceleratorWithSuccess() throws Exception {
		
		AcceleratorInputRequest request = new AcceleratorInputRequest();
		request.setInput("3 1 3");
		
		String json = gson.toJson(request, AcceleratorInputRequest.class);
		
		//WHEN
		mockMvc.perform(MockMvcRequestBuilders.post("/challenge/accelerator")
						.content(json)
						.header("Content-Type", "application/json"))
		.andExpect(status().isOk());

	
	}
	
}
