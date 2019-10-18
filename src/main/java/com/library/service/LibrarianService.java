package com.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.exception.LibrarianBadRequest;
import com.library.exception.LibrarianNotFoundException;
import com.library.model.LibrarianDto;
import com.library.repository.LibrarianRepository;

@Service
public class LibrarianService implements LibrarianDAO {

	@Autowired
	private LibrarianRepository librarianRepository;
	

	public LibrarianDto add(LibrarianDto librarianDto) {
		librarianDto = librarianRepository.save(librarianDto);
		return librarianDto;
	}
	
	public LibrarianDto update(LibrarianDto librarianDto) {
		if (null != librarianDto.getId()) {
			librarianDto = librarianRepository.save(librarianDto);
		} else {
			throw new LibrarianBadRequest("Librarian Not Found");
		}
		
		return librarianDto;
	}

	public LibrarianDto find(long id) {
		Optional<LibrarianDto> optional = librarianRepository.findById(id);
		
		return optional.orElseThrow(() -> new LibrarianNotFoundException("Not Found id:"+id));
	}

	public List<LibrarianDto> findAll() {
		return librarianRepository.findAll();
	}

	public void delete(long id) throws LibrarianNotFoundException {
		Optional<LibrarianDto> optional = librarianRepository.findById(id);
		optional.orElseThrow(() -> new LibrarianNotFoundException("Not Found id:"+id));

		librarianRepository.deleteById(id);
	}

	
}
