package com.library.exception;

import org.springframework.http.HttpStatus;

public class LibrarianBadRequest extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	private int statusCode;
	
	public LibrarianBadRequest(String msg) {
		super(msg);
		this.message = msg;
		this.statusCode = HttpStatus.BAD_REQUEST.value();
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