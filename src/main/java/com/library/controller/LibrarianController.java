package com.library.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.library.model.LibrarianDto;
import com.library.service.LibrarianService;

@RestController
@RequestMapping("/librarian")
public class LibrarianController {

	@Autowired
	private LibrarianService librarianService;
	
	@PostMapping
	public ResponseEntity<Object> addLibrarian(@RequestBody LibrarianDto librarianDto) {

		librarianDto = librarianService.add(librarianDto);

		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(librarianDto.getId())
						.toUri();

		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> updateLibrarian(@RequestBody LibrarianDto librarianDto) {

		librarianDto = librarianService.update(librarianDto);

		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(librarianDto.getId())
						.toUri();

		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/findall")
	public List<LibrarianDto> findAllLibrarian() {
		
		List<LibrarianDto> librarianDtos = librarianService.findAll();
		
		return librarianDtos;
	}
	
	@GetMapping("/{id}")
	public Resource<LibrarianDto> find(@PathVariable long id) {
		
		LibrarianDto librarianDto = librarianService.find(id);
		
		Resource<LibrarianDto> resource = new Resource<>(librarianDto);
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).findAllLibrarian());
		resource.add(linkTo.withRel("all-librarian"));
		
		return resource;
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		
		librarianService.delete(id);
		
		return ResponseEntity.ok().body("Deleted Successfully id:"+id);
	}
}
