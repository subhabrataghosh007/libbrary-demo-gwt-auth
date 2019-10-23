package com.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.library.exception.BadRequestException;
import com.library.exception.NotFoundException;
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
	
	public User update(User user, Long id) {
		if (null != id) {
			user = userRepository.save(user);
		} else {
			throw new BadRequestException("Librarian Not Found");
		}
		
		return user;
	}

	public User find(long id) {
		Optional<User> optional = userRepository.findById(id);
		
		return optional.orElseThrow(() -> new NotFoundException("Not Found id:"+id));
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public void delete(long id) throws NotFoundException {
		Optional<User> optional = userRepository.findById(id);
		optional.orElseThrow(() -> new NotFoundException("Not Found id:"+id));

		userRepository.deleteById(id);
	}

	
}
