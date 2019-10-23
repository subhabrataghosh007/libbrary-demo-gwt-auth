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

import com.library.model.User;
import com.library.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	public ResponseEntity<Object> addLibrarian(@RequestBody User user) {

		user = userService.add(user);

		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(user.getId())
						.toUri();

		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateLibrarian(@RequestBody User user, @PathVariable Long id) {

		user = userService.update(user, id);

		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(user.getId())
						.toUri();

		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/findall")
	public List<User> findAllLibrarian() {
		
		List<User> users = userService.findAll();
		
		return users;
	}
	
	@GetMapping("/find/{id}")
	public Resource<User> find(@PathVariable long id) {
		
		User user = userService.find(id);
		
		Resource<User> resource = new Resource<>(user);
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).findAllLibrarian());
		resource.add(linkTo.withRel("all-librarian"));
		
		return resource;
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		
		userService.delete(id);
		
		return ResponseEntity.ok().body("Deleted Successfully id:"+id);
	}
}
