package com.ciandt.challenge.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class AcceleratorInputRequest {
	
	private String input;
	
	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
}

