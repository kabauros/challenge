package com.ciandt.challenge.converter.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ciandt.challenge.converter.AcceleratorRequestToInput;
import com.ciandt.challenge.exception.AcceleratorInputException;
import com.ciandt.challenge.validator.AcceleratorInputRequestValidator;
import com.ciandt.challenge.vo.AcceleratorInput;
import com.ciandt.challenge.vo.AcceleratorInputRequest;

@RunWith(MockitoJUnitRunner.class)
public class AcceleratorRequestToInputTest {
	
	@InjectMocks
	private AcceleratorRequestToInput acceleratorRequestToInput;
	
	@Mock
	private AcceleratorInputRequestValidator validatorRequest;
	
	@Test(expected = AcceleratorInputException.class)
	public void testInputNoNumericAcceleratorInputException() {

		AcceleratorInputRequest request = new AcceleratorInputRequest();
		request.setInput("A B C");

		doThrow(AcceleratorInputException.class).when(validatorRequest).inputRequestIsValid(request);

		acceleratorRequestToInput.convertToInput(request);

	}
	
	@Test(expected = AcceleratorInputException.class)
	public void testInputNullAcceleratorInputException() {

		AcceleratorInputRequest request = null;

		doThrow(AcceleratorInputException.class).when(validatorRequest).inputRequestIsValid(request);

		acceleratorRequestToInput.convertToInput(request);

	}
	
	
	@Test
	public void testSucess() {

		AcceleratorInputRequest request = new AcceleratorInputRequest();
		request.setInput("3 1 3");

		AcceleratorInput input = new AcceleratorInput();
		input.setA(3);
		input.setN(1);
		input.setK(3);

		doNothing().when(validatorRequest).inputRequestIsValid(request);

		AcceleratorInput accelerator = acceleratorRequestToInput.convertToInput(request);

		// THEN
		assertThat(accelerator, notNullValue());
		assertThat(accelerator.getA(), Matchers.is(Matchers.equalTo(input.getA())));
		assertThat(accelerator.getN(), Matchers.is(Matchers.equalTo(input.getN())));
		assertThat(accelerator.getK(), Matchers.is(Matchers.equalTo(input.getK())));
	}

}
