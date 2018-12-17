package com.ciandt.challenge.business.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ciandt.challenge.business.AcceleratorBusiness;
import com.ciandt.challenge.converter.AcceleratorArrayToStringOutput;
import com.ciandt.challenge.converter.AcceleratorRequestToInput;
import com.ciandt.challenge.validator.AcceleratorInputValidator;
import com.ciandt.challenge.vo.AcceleratorInput;
import com.ciandt.challenge.vo.AcceleratorInputRequest;

@RunWith(MockitoJUnitRunner.class)
public class AcceleratorBusinessTest {

	@InjectMocks
	private AcceleratorBusiness acceleratorBusiness;
	
	@Mock
	private AcceleratorInputValidator validatorInput;

	@Mock
	private AcceleratorRequestToInput requestToInput;
	
	@Mock
	private AcceleratorArrayToStringOutput acceleratorArrayToStringOutput;

	public @Rule ExpectedException thrown = ExpectedException.none();


	@Test
	public void testSucess() {

		AcceleratorInputRequest inputRequest = new AcceleratorInputRequest();
		inputRequest.setInput("3 1 3");

		String expectedOutput = "110";

		AcceleratorInput input = new AcceleratorInput();
		input.setA(3);
		input.setN(1);
		input.setK(3);

		when(requestToInput.convertToInput(inputRequest)).thenReturn(input);
		doNothing().when(validatorInput).inputIsValid(input);
		when(acceleratorArrayToStringOutput.arrayToString(any(int[].class))).thenReturn("110");

		String accelerator = acceleratorBusiness.process(inputRequest);

		// THEN
		assertThat(accelerator, notNullValue());
		assertThat(accelerator, Matchers.is(Matchers.equalTo(expectedOutput)));
	}

}
