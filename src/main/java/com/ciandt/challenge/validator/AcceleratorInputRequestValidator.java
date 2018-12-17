package com.ciandt.challenge.validator;

import static org.apache.commons.lang3.StringUtils.isNumeric;
import org.springframework.stereotype.Component;
import com.ciandt.challenge.exception.AcceleratorInputException;
import com.ciandt.challenge.vo.AcceleratorInputRequest;

@Component
public class AcceleratorInputRequestValidator {

	public void inputRequestIsValid(AcceleratorInputRequest input) throws AcceleratorInputException {

		if (input == null || input.getInput() == null ||  input.getInput().isEmpty()) {
			throw new AcceleratorInputException("Entry can not be null or empty");
		}

		if (!isNumeric(input.getInput().replaceAll("\\s+","")) ||  input.getInput().length()!= 5) {
			throw new AcceleratorInputException("Items A, N, and K must be numbers separated by single space");
		}
	}

}
