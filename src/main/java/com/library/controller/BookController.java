package com.library.controller;

import java.net.URI;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.library.model.BookModel;
import com.library.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping
	public ResponseEntity<BookModel> addBook(@RequestBody BookModel bookModel) {
		bookModel = bookService.add(bookModel);
		
		URI location = ServletUriComponentsBuilder
							.fromCurrentRequest()
							.path("{id}")
							.buildAndExpand(bookModel.getId())
							.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<BookModel> updateBook(@RequestBody BookModel bookModel, @PathVariable Long id) {
		bookModel = bookService.update(bookModel, id);
		
		return ResponseEntity.status(204).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookModel> findBook(@PathVariable Long id) {
		
		BookModel bookModel = bookService.find(id);
		return ResponseEntity.ok(bookModel);
	}
	
	@GetMapping("/findall")
	public ResponseEntity<List<BookModel>> findAllBooks() {

		List<BookModel> books = bookService.findAll();
		return ResponseEntity.ok(books);
	}
}
