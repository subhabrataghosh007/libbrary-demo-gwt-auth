package com.library.bean;


public class ErrorResponse {

	private String message;
	private int statusCode;
	
	public ErrorResponse() {}
	
	public ErrorResponse(String message, int statusCode) {
		this.setMessage(message);
		this.setStatusCode(statusCode);
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
