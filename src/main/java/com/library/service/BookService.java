package com.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.exception.BadRequestException;
import com.library.exception.NotFoundException;
import com.library.model.BookModel;
import com.library.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public BookModel add(BookModel bookModel) {

		bookModel = bookRepository.save(bookModel);
		return bookModel;
	}

	public BookModel update(BookModel bookModel, Long id) {

		if (id != null) {
			bookModel.setId(id);
			bookModel = bookRepository.save(bookModel);
		} else {
			throw new BadRequestException("Id should not empty or null");
		}
		
		return bookModel;
	}

	public BookModel find(Long id) {
		
		Optional<BookModel> optionalBookModel = bookRepository.findById(id);
		return optionalBookModel.orElseThrow(() -> new NotFoundException("User not Found"));
		
	}

	public List<BookModel> findAll() {
		
		List<BookModel> books = bookRepository.findAll();
		return books;
	}

}
