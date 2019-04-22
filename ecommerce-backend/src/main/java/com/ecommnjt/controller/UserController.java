package com.ecommnjt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommnjt.dto.UserDTO;
import com.ecommnjt.model.User;
import com.ecommnjt.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<UserDTO> login() {
		return new ResponseEntity<>(new UserDTO(), HttpStatus.OK);
	}
	
	@GetMapping("/getUser")
	public ResponseEntity<UserDTO> testEndpoint() {
		User user = userService.findById(1).get();
		UserDTO userDTO = new UserDTO(user);
		return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}
}
