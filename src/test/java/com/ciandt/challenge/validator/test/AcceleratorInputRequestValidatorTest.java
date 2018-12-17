package com.ciandt.challenge.validator.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.ciandt.challenge.exception.AcceleratorInputException;
import com.ciandt.challenge.validator.AcceleratorInputRequestValidator;
import com.ciandt.challenge.vo.AcceleratorInputRequest;

@RunWith(MockitoJUnitRunner.class)
public class AcceleratorInputRequestValidatorTest {
	
	@InjectMocks
	private AcceleratorInputRequestValidator acceleratorInputValidator;
	

	@Test(expected = AcceleratorInputException.class)
	public void testInputNullAcceleratorInputException() {

		AcceleratorInputRequest input = null;

		acceleratorInputValidator.inputRequestIsValid(input);

	}
	
	@Test(expected = AcceleratorInputException.class)
	public void testGetInputNullAcceleratorInputException() {

		AcceleratorInputRequest input = new AcceleratorInputRequest();

		acceleratorInputValidator.inputRequestIsValid(input);

	}
	
	@Test(expected = AcceleratorInputException.class)
	public void testGetInputEmptyAcceleratorInputException() {

		AcceleratorInputRequest input = new AcceleratorInputRequest();
		input.setInput("");

		acceleratorInputValidator.inputRequestIsValid(input);

	}
	

	@Test(expected = AcceleratorInputException.class)
	public void testInputNoNumericAcceleratorInputException() {

		AcceleratorInputRequest input = new AcceleratorInputRequest();
		input.setInput("A B C");

		acceleratorInputValidator.inputRequestIsValid(input);

	}
	
	@Test()
	public void success() {

		AcceleratorInputRequest input = new AcceleratorInputRequest();
		input.setInput("3 1 3");

		acceleratorInputValidator.inputRequestIsValid(input);

	}
}
