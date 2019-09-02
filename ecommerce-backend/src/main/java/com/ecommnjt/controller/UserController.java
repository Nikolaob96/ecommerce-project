package com.ecommnjt.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommnjt.dto.LoginDTO;
import com.ecommnjt.dto.ProductDTO;
import com.ecommnjt.dto.UserDTO;
import com.ecommnjt.model.User;
import com.ecommnjt.security.JwtTokenProvider;
import com.ecommnjt.service.UserDetailsServiceImpl;
import com.ecommnjt.service.UserServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class UserController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
    JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@ApiOperation(value = "Authenticates the user",
	notes = "TO DO...",
	response = LoginDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = LoginDTO.class),
			@ApiResponse(code = 500, message = "Failure"), @ApiResponse(code = 400, message = "Bad request") })
	public ResponseEntity<String> login(
			@ApiParam(value = "The loginDTO object", required = true)  @RequestBody LoginDTO loginDTO) {
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
	
	@RequestMapping(value = "/users/{username}", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the user with specific username",
	notes = "TO DO...",
	response = UserDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = UserDTO.class),
			@ApiResponse(code = 404, message = "Not found") })
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public ResponseEntity<UserDTO> getUserByUsername(
			@ApiParam(value = "The username of the user.", required = true) @PathVariable String username) {
		UserDTO userDTO = userService.findByUsername(username);
		
		if(userDTO == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}
}
