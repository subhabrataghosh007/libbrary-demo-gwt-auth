package com.library.service;

import java.util.List;

import com.library.exception.LibrarianNotFoundException;
import com.library.model.LibrarianDto;
import com.library.model.User;

public interface UserDAO {

	public User add(User user);
	public User find(long id);
	public List<User> findAll();
	public void delete(long id);
}
