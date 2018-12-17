package com.ciandt.challenge.converter.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.ciandt.challenge.converter.AcceleratorArrayToStringOutput;

@RunWith(MockitoJUnitRunner.class)
public class AcceleratorArrayToStringOutputTest {
	
	@InjectMocks
	private AcceleratorArrayToStringOutput converter;
	
	@Test
	public void converterSuccess() {
		
		int [] input = {3, 1, 3};
		
		String output = converter.arrayToString(input);
		
		assertEquals("313", output);
		
	}
	
	
	@Test
	public void converterNull() {
		
		int [] input = null;
		
		String output = converter.arrayToString(input);
		
		assertNull(output);
		
	}
	

}
