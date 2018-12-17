package com.ciandt.challenge.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ciandt.challenge.exception.AcceleratorInputException;

@ControllerAdvice
public class ExceptionHandlerController {
	
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { 
			AcceleratorInputException.class})
	public ErrorResponse handleClientBadRequest(Exception e) {
		
		return new ErrorResponse().withHttpStatus(HttpStatus.BAD_REQUEST)
				.withMessage(e.getMessage());
	}

}
