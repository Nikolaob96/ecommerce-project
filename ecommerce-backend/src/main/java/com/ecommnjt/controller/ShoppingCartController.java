package com.ecommnjt.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommnjt.dto.ShoppingCartDTO;
import com.ecommnjt.model.ShoppingCart;
import com.ecommnjt.service.ShoppingCartService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@PostMapping("/ShoppingCart")
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public ResponseEntity<ShoppingCartDTO> createShoppingCart(@RequestBody String asd) {
		ShoppingCart shoppingCart = shoppingCartService.createShoppingCart();
		ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO(shoppingCart);
		return new ResponseEntity<>(shoppingCartDTO, HttpStatus.OK);
	}
	
	@GetMapping("/ShoppingCart")
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public ResponseEntity<ShoppingCartDTO> getShoppingCart(@PathVariable int cartId) {
		ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(cartId);
		return new ResponseEntity<>(new ShoppingCartDTO(shoppingCart), HttpStatus.OK);
	}
	
}
