package com.ecommnjt.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecommnjt.dto.ShoppingCartDTO;
import com.ecommnjt.dto.ShoppingCartItemDTO;
import com.ecommnjt.model.ShoppingCart;
import com.ecommnjt.service.ShoppingCartItemServiceImpl;
import com.ecommnjt.service.ShoppingCartServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ShoppingCartItemController {
	
	@Autowired
	private ShoppingCartItemServiceImpl cartItemService;
	
	@Autowired
	private ShoppingCartServiceImpl cartService;
	
	@RequestMapping(value = "/shopping-cart/{cartId}/cart-items/{productId}", method = RequestMethod.GET)
	@ApiOperation(value = "Returns a shopping cart item with specific id",
	notes = "TO DO...",
	response = ShoppingCartItemDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ShoppingCartItemDTO.class),
			@ApiResponse(code = 404, message = "Not found") })
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public ResponseEntity<ShoppingCartItemDTO> findShoppingCartItem(
			@ApiParam(value = "The ID of a cart.", required = true) @PathVariable("cartId") int cartId, 
			@ApiParam(value = "The ID of a product in a cart.", required = true) @PathVariable("productId") int productId) {
		ShoppingCartItemDTO cartItemDTO = cartItemService.getCartItem(cartId, productId);
		if(cartItemDTO == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(cartItemDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cart-items", method = RequestMethod.PUT)
	@ApiOperation(value = "Update a specific cart item")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ShoppingCartItemDTO.class),
			@ApiResponse(code = 500, message = "Failure"), @ApiResponse(code = 400, message = "Bad request") })
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public ResponseEntity<ShoppingCartItemDTO> updateQuantity(
			@ApiParam(value = "ShoppingCartItem DTO object.", required = true) @RequestBody ShoppingCartItemDTO cartItem) {
		
		if(cartItem == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		cartItemService.update(cartItem);
		return new ResponseEntity<>(cartItem,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cart-items", method = RequestMethod.POST)
	@ApiOperation(value = "Adds a new cart item",
	notes = "TO DO...",
	response = ShoppingCartItemDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ShoppingCartItemDTO.class),
			@ApiResponse(code = 500, message = "Failure"), @ApiResponse(code = 400, message = "Bad request") })
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@Transactional
	public ResponseEntity<ShoppingCartItemDTO> addItem(
			@ApiParam(value = "ShoppingCartItem DTO object.", required = true) @RequestBody ShoppingCartItemDTO cartItem) {
		
		if(cartItem == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		cartItemService.save(cartItem);
		return new ResponseEntity<>(cartItem, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/cart-items/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Returns a cart item with specific id",
	notes = "TO DO...",
	response = ShoppingCartItemDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ShoppingCartItemDTO.class),
			@ApiResponse(code = 404, message = "Not found") })
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public ResponseEntity<ShoppingCartItemDTO> getItem(
			@ApiParam(value = "The ID of a cart item.", required = true) @PathVariable int id) {
		ShoppingCartItemDTO cartDTO = cartItemService.getItem(id);
		
		if(cartDTO == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(cartDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cart-items/{cartId}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete cart items.", httpMethod = "DELETE")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 400, message = "Bad request") })
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public ResponseEntity<ShoppingCartDTO> clearShoppingCart(
			@ApiParam(value = "The ID of a cart whose items to delete.", required = true) @PathVariable int cartId) {
		
		if(cartId == 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		cartItemService.clearShoppingCart(cartId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cart-items/{cartId}/{itemId}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete specific item from cart.", httpMethod = "DELETE")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 400, message = "Bad request") })
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public ResponseEntity<ShoppingCartDTO> clearShoppingCart(
			@ApiParam(value = "The ID of a cart.", required = true) @PathVariable("cartId") int cartId, 
			@ApiParam(value = "The ID of a product from the cart.", required = true) @PathVariable("itemId") int productId) {
		
		if(cartId == 0 || productId == 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		cartItemService.deleteItem(cartId, productId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// New end point for mobile version of the application(different approach)
	
	@PostMapping("/ShoppingCartCheckout")
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@Transactional
	public ResponseEntity<Integer> saveCartAndItems(@RequestBody List<ShoppingCartItemDTO> cartItems) {
		ShoppingCart sc = cartService.createShoppingCart();
		
		cartItemService.saveItems(cartItems, sc.getId());
		return new ResponseEntity<>(sc.getId(), HttpStatus.OK);
	}
	
	
}
