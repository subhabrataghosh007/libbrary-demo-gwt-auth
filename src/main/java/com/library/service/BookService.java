package com.library.service;

import org.springframework.stereotype.Service;

import com.library.model.BookModel;
import com.library.repository.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepository;
	
	public BookModel add(BookModel bookModel) {
		
		bookModel = bookRepository.save(bookModel);
		return bookModel;
	}
	
}
