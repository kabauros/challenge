package com.ciandt.challenge.converter;

import org.springframework.stereotype.Component;

@Component
public class AcceleratorArrayToStringOutput {

	public String arrayToString(int[] accelerator) {

		if (accelerator != null) {

			StringBuilder output = new StringBuilder();
			for (int i = 0; i < accelerator.length; i++) {
				output.append(accelerator[i]);
			}
			return output.toString();
		}else {
			return null;
		}
	}

}
