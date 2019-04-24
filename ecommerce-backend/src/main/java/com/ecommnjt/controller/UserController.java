package com.ecommnjt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommnjt.dto.LoginDTO;
import com.ecommnjt.dto.UserDTO;
import com.ecommnjt.model.User;
import com.ecommnjt.security.JwtTokenProvider;
import com.ecommnjt.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
    JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<Map<Object, Object>> login(@RequestBody LoginDTO loginDTO) {
		try {
		String username = loginDTO.getUsername();
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, loginDTO.getPassword()));
		String token = jwtTokenProvider.createToken(username, this.userService.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found")).getRoles());
        Map<Object, Object> model = new HashMap<>();
        model.put("username", username);
        model.put("token", token);
		return new ResponseEntity<>(model, HttpStatus.OK);
		} catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
	}
	
	@GetMapping("/getUser")
	public ResponseEntity<UserDTO> testEndpoint() {
		User user = userService.findById(1).get();
		UserDTO userDTO = new UserDTO(user);
		return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}
}
