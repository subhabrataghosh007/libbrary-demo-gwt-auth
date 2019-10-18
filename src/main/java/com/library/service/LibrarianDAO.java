package com.library.service;

import java.util.List;

import com.library.exception.LibrarianNotFoundException;
import com.library.model.LibrarianDto;

public interface LibrarianDAO {

	public LibrarianDto add(LibrarianDto librarianDto);
	public LibrarianDto find(long id);
	public List<LibrarianDto> findAll();
	public void delete(long id);
}
