package com.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.library.bean.ErrorResponse;

@RestControllerAdvice
public class ExceptionHandling {
	
	
	@ExceptionHandler(value = {LibrarianNotFoundException.class})
	public ResponseEntity<ErrorResponse> notFound(LibrarianNotFoundException e) {
		
		ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), e.getStatusCode());
		
		return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
		
	}
	
	@ExceptionHandler(value = {LibrarianBadRequest.class})
	public ResponseEntity<ErrorResponse> badRequest(LibrarianBadRequest e) {
		
		ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), e.getStatusCode());
		
		return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
		
	}

}
