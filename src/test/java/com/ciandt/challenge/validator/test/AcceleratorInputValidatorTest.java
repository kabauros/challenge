package com.ciandt.challenge.validator.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.ciandt.challenge.exception.AcceleratorInputException;
import com.ciandt.challenge.validator.AcceleratorInputValidator;
import com.ciandt.challenge.vo.AcceleratorInput;

@RunWith(MockitoJUnitRunner.class)
public class AcceleratorInputValidatorTest {
	
	@InjectMocks
	private AcceleratorInputValidator acceleratorInputValidator;
	
	
	@Test(expected = AcceleratorInputException.class)
	public void testInputNull() {
		AcceleratorInput input = null;
		acceleratorInputValidator.inputIsValid(input);
	}
	
	@Test(expected = AcceleratorInputException.class)
	public void testeALessThanZero() {
		AcceleratorInput input = new AcceleratorInput();
		input.setA(-1);
		input.setN(1);
		input.setK(1);
		acceleratorInputValidator.inputIsValid(input);
	}

	
	@Test(expected = AcceleratorInputException.class)
	public void testeAMoreThan() {
		AcceleratorInput input = new AcceleratorInput();
		input.setA(1000000001);
		input.setN(1);
		input.setK(1);
		acceleratorInputValidator.inputIsValid(input);
	}
	
	
	@Test(expected = AcceleratorInputException.class)
	public void testeNLessThanZero() {
		AcceleratorInput input = new AcceleratorInput();
		input.setA(1);
		input.setN(-1);
		input.setK(1);
		acceleratorInputValidator.inputIsValid(input);
	}

	
	@Test(expected = AcceleratorInputException.class)
	public void testeNMoreThan() {
		AcceleratorInput input = new AcceleratorInput();
		input.setA(1);
		input.setN(101);
		input.setK(1);
		acceleratorInputValidator.inputIsValid(input);
	}
	
	
	@Test(expected = AcceleratorInputException.class)
	public void testeKLessThanZero() {
		AcceleratorInput input = new AcceleratorInput();
		input.setA(1);
		input.setN(1);
		input.setK(-1);
		acceleratorInputValidator.inputIsValid(input);
	}

	
	@Test(expected = AcceleratorInputException.class)
	public void testeKMoreThan() {
		AcceleratorInput input = new AcceleratorInput();
		input.setA(1);
		input.setN(1);
		input.setK(101);
		acceleratorInputValidator.inputIsValid(input);
	}
	
}
