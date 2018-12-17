package com.ciandt.challenge.validator;

import org.springframework.stereotype.Component;

import com.ciandt.challenge.exception.AcceleratorInputException;
import com.ciandt.challenge.vo.AcceleratorInput;

@Component
public class AcceleratorInputValidator {

	public void inputIsValid(AcceleratorInput input) {

		if (input == null) {
			throw new AcceleratorInputException("Input can't be null");
		}
		
		if (input.getA() < 0) {
			throw new AcceleratorInputException("A must be greater than zero");
		}

		if (input.getA() > 1000000000) {
			throw new AcceleratorInputException("A must be less than 1000000000");
		}

		if (input.getN() < 0) {
			throw new AcceleratorInputException("A must be greater than zero");
		}

		if (input.getN() > 100) {
			throw new AcceleratorInputException("N must be less than 100");
		}

		if (input.getK() < 0) {
			throw new AcceleratorInputException("A must be greater than zero");
		}

		if (input.getK() > 100) {
			throw new AcceleratorInputException("K must be less than 100");
		}
	}

}
