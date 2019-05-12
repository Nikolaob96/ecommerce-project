package com.ecommnjt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommnjt.dto.LoginDTO;
import com.ecommnjt.dto.UserDTO;
import com.ecommnjt.model.User;
import com.ecommnjt.security.JwtTokenProvider;
import com.ecommnjt.service.UserDetailsServiceImpl;
import com.ecommnjt.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class UserController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
    JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
		//Map<Object, Object> model = new HashMap<>();
		try {
		String username = loginDTO.getUsername();
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, loginDTO.getPassword()));
		String token = jwtTokenProvider.createToken(userDetailsServiceImpl.loadUserByUsername(username));
		
        //model.put("token", token);
		return new ResponseEntity<>(token, HttpStatus.OK);
		} catch (Exception e) {
			//model.put("error", "Invalid Login");
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        }
	}
	
	@GetMapping("/getUser")
	public ResponseEntity<UserDTO> testEndpoint() {
		User user = userService.findById(1).get();
		UserDTO userDTO = new UserDTO(user);
		return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}
}
