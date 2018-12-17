package com.ciandt.challenge.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ciandt.challenge.converter.AcceleratorArrayToStringOutput;
import com.ciandt.challenge.converter.AcceleratorRequestToInput;
import com.ciandt.challenge.exception.AcceleratorInputException;
import com.ciandt.challenge.validator.AcceleratorInputValidator;
import com.ciandt.challenge.vo.AcceleratorInput;
import com.ciandt.challenge.vo.AcceleratorInputRequest;

@Component
public class AcceleratorBusiness {

	@Autowired
	private AcceleratorInputValidator validatorInput;

	@Autowired
	private AcceleratorRequestToInput acceleratorRequestToInput;
	
	@Autowired
	private AcceleratorArrayToStringOutput acceleratorArrayToStringOutput;
	
	public String process(AcceleratorInputRequest inputRequest) throws AcceleratorInputException {
				
		AcceleratorInput input = acceleratorRequestToInput.convertToInput(inputRequest);
		
		validatorInput.inputIsValid(input);

		int accelerator[] = new int[input.getK()];
		
		for (int i = 0; i < input.getA(); i++) {
			boolean controleLinha = true;
			boolean controleColuna  = true;
			
			for (int j = 0; j < input.getK(); j++) {
				
				if(accelerator[j] < input.getN() && controleLinha) {
					accelerator[j] ++ ;
					controleLinha = false;
					controleColuna = false;
				}else {
					if(controleColuna) {
						accelerator[j] = 0;
					}
				}
				System.out.printf("%d ", accelerator[j]);			
			}
			
			System.out.printf("\n");
		}
		
		return acceleratorArrayToStringOutput.arrayToString(accelerator);
		
	}

}
