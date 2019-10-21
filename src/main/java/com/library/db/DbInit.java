package com.library.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.library.model.User;
import com.library.repository.UserRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void run(String... args) {
		// Delete all
		this.userRepository.deleteAll();

		// Crete users
		User admin = new User("admin", passwordEncoder.encode("admin123"), "ADMIN", "ACCESS_TEST1");
		//User rdas = new User("rdas", passwordEncoder.encode("password123"), "ADMIN", "ACCESS_TEST1");

		List<User> users = Arrays.asList(admin);

		// Save to db
		this.userRepository.saveAll(users);
	}
}