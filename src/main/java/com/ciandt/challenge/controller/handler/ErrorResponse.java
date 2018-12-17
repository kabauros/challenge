package com.ciandt.challenge.controller.handler;

import java.util.Objects;
import java.util.UUID;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ErrorResponse {

	private String system = "accelerator";

	private String message;
	private int httpStatus;
	private UUID requestId;

	public String getSystem() {
		return system;
	}

	public String getMessage() {
		return message;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public UUID getRequestId() {
		return requestId;
	}

	public ErrorResponse withMessage(String message) {
		this.message = message;
		return this;
	}

	public ErrorResponse withHttpStatus(HttpStatus httpStatus) {
		Objects.requireNonNull(httpStatus);
		this.httpStatus = httpStatus.value();
		return this;
	}

}
