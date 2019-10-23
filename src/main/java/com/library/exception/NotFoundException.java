package com.library.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	private int statusCode;
	
	public NotFoundException(String msg) {
		super(msg);
		this.message = msg;
		this.statusCode = HttpStatus.NOT_FOUND.value();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
