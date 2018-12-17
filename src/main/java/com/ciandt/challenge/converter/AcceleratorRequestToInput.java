package com.ciandt.challenge.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ciandt.challenge.validator.AcceleratorInputRequestValidator;
import com.ciandt.challenge.vo.AcceleratorInput;
import com.ciandt.challenge.vo.AcceleratorInputRequest;

@Component
public class AcceleratorRequestToInput {
	
	@Autowired
	private AcceleratorInputRequestValidator validatorRequest;
	
	public AcceleratorInput convertToInput(AcceleratorInputRequest request) {
		
		validatorRequest.inputRequestIsValid(request);
		
		AcceleratorInput input  = new AcceleratorInput();
		
		String inputParser [] = request.getInput().split(" ");
	
		// A Número total de átomos
		input.setA(Integer.parseInt(inputParser[0]));

		// N Número máximo de átomos por região
		input.setN(Integer.parseInt(inputParser[1]));

		// K Número de Regiões
		input.setK(Integer.parseInt(inputParser[2]));
		
		return input;
		
	}

}
