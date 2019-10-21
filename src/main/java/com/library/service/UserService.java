package com.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.library.exception.LibrarianBadRequest;
import com.library.exception.LibrarianNotFoundException;
import com.library.model.User;
import com.library.repository.UserRepository;

@Service
public class UserService implements UserDAO {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public User add(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user = userRepository.save(user);
		return user;
	}
	
	public User update(User user) {
		if (null != user.getId()) {
			user = userRepository.save(user);
		} else {
			throw new LibrarianBadRequest("Librarian Not Found");
		}
		
		return user;
	}

	public User find(long id) {
		Optional<User> optional = userRepository.findById(id);
		
		return optional.orElseThrow(() -> new LibrarianNotFoundException("Not Found id:"+id));
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public void delete(long id) throws LibrarianNotFoundException {
		Optional<User> optional = userRepository.findById(id);
		optional.orElseThrow(() -> new LibrarianNotFoundException("Not Found id:"+id));

		userRepository.deleteById(id);
	}

	
}
