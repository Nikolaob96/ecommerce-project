package com.ecommnjt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommnjt.dto.UserDTO;

@RestController
@RequestMapping("/api")
public class UserController {

	@PostMapping("/login")
	public ResponseEntity<UserDTO> login() {
		return new ResponseEntity<>(new UserDTO(), HttpStatus.OK);
	}
}
