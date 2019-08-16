package com.ecommnjt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommnjt.dto.ShoppingCartDTO;
import com.ecommnjt.dto.ShoppingCartItemDTO;
import com.ecommnjt.model.ShoppingCart;
import com.ecommnjt.service.ShoppingCartItemServiceImpl;

@Controller
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ShoppingCartItemController {
	
	@Autowired
	private ShoppingCartItemServiceImpl cartItemService;
	
	@GetMapping("/ShoppingCart/{cartId}/CartItems/{productId}")
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public ResponseEntity<ShoppingCartItemDTO> findShoppingCartItem(@PathVariable("cartId") int cartId, @PathVariable("productId") int productId) {
		ShoppingCartItemDTO cartItemDTO = cartItemService.getCartItem(cartId, productId);
		return new ResponseEntity<>(cartItemDTO, HttpStatus.OK);
	}
	
	@PutMapping("/ShoppingCartItemQuantity")
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public ResponseEntity<ShoppingCartItemDTO> updateQuantity(@RequestBody ShoppingCartItemDTO cartItem) {
		cartItemService.update(cartItem);
		return new ResponseEntity<>(cartItem,HttpStatus.OK);
	}
	
	@PostMapping("/ShoppingCartItems")
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@Transactional
	public ResponseEntity<ShoppingCartItemDTO> addItem(@RequestBody ShoppingCartItemDTO cartItem) {
		cartItemService.save(cartItem);
		return new ResponseEntity<>(cartItem, HttpStatus.OK);
	}
	
	@GetMapping("/CartItems/{id}")
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public ResponseEntity<ShoppingCartItemDTO> getItem(@PathVariable int id) {
		ShoppingCartItemDTO cartDTO = cartItemService.getItem(id);
		return new ResponseEntity<>(cartDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/ShoppingCart/{cartId}")
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public ResponseEntity<ShoppingCartDTO> clearShoppingCart(@PathVariable int cartId) {
		cartItemService.clearShoppingCart(cartId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/ShoppingCartItems/{cartId}/{itemId}")
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public ResponseEntity<ShoppingCartDTO> clearShoppingCart(@PathVariable("cartId") int cartId, @PathVariable("itemId") int productId) {
		cartItemService.deleteItem(cartId, productId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
