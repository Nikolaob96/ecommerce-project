package com.ecommnjt.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommnjt.model.User;
import com.ecommnjt.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}

	public Optional<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}