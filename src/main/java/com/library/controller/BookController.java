package com.library.controller;

import java.net.URI;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.library.model.BookModel;
import com.library.service.BookService;

@RestController("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping("/add")
	public ResponseEntity<BookModel> addBook(@RequestBody BookModel bookModel) {
		bookModel = bookService.add(bookModel);
		
		URI location = ServletUriComponentsBuilder
							.fromCurrentRequest()
							.path("{id}")
							.buildAndExpand(bookModel.getId())
							.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
