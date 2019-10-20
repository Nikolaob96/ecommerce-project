package com.ecommnjt.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommnjt.dto.UserDTO;
import com.ecommnjt.mapper.UserMapperImpl;
import com.ecommnjt.model.User;
import com.ecommnjt.repository.UserRepository;

@Service
public class UserServiceImpl {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapperImpl userMapper;
	
	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}

	public UserDTO findByUsername(String username) {
		Optional<User> user = userRepository.findByUsername(username);
		
		UserDTO userDTO = null;
		
		if(user.isPresent()) {
			userDTO = userMapper.toUserDTO(user.get());
		}
		return userDTO;
	}
}
