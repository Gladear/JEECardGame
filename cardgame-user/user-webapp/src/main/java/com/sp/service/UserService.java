package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sp.model.User;
import com.sp.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository uRepository;
	
	public void addUser(User user) {
		uRepository.save(user);
	}
	
	public Integer login(String username, String password) {
		Optional<User> optUser = uRepository.findByName(username);
		if (!optUser.isPresent()) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
		User user = optUser.get();
		if (!user.getPassword().equals(password)) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
		return user.getId();
	}
	
	public User getUser(Integer id) {
		Optional<User> user = uRepository.findById(id);
		return user.orElse(null);
	}

	public Iterable<User> getAll() {
		// TODO Auto-generated method stub
		return uRepository.findAll();
	}
}
