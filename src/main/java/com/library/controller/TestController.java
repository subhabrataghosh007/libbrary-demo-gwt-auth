package com.library.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.bean.Test;

@RestController
public class TestController {

	@GetMapping("/test")
	public String test() {
		return "Test..";
	}
	
	@GetMapping("/testpojo")
	public ResponseEntity<Test> test2() {
		
		Test t = new Test("Ram", "Das");
		
		return new ResponseEntity<Test>(t, HttpStatus.OK);
	}
	
	@GetMapping("/Admin")
	public String test3() {
		return "Test..";
	}
	
}
