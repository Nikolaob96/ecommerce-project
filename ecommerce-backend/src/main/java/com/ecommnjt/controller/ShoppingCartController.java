package com.ecommnjt.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommnjt.dto.ProductDTO;
import com.ecommnjt.dto.ShoppingCartDTO;
import com.ecommnjt.model.ShoppingCart;
import com.ecommnjt.service.ShoppingCartServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCartServiceImpl shoppingCartService;
	
	@RequestMapping(value = "/shopping-cart", method = RequestMethod.POST)
	@ApiOperation(value = "Adds a new shopping cart",
	response = ShoppingCartDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ShoppingCartDTO.class),
			@ApiResponse(code = 500, message = "Failure") })
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public ResponseEntity<ShoppingCartDTO> createShoppingCart() {
		ShoppingCart shoppingCart = shoppingCartService.createShoppingCart();
		ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO(shoppingCart);
		return new ResponseEntity<>(shoppingCartDTO, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/shopping-cart/{cartId}", method = RequestMethod.GET)
	@ApiOperation(value = "Returns a shopping cart with specific id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ShoppingCartDTO.class),
			@ApiResponse(code = 404, message = "Not found") })
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public ResponseEntity<ShoppingCartDTO> getShoppingCart(
			@ApiParam(name = "cartId", value = "id of a specific cart", required = true) @PathVariable int cartId) {
		ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(cartId);
		
		if(shoppingCart == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new ShoppingCartDTO(shoppingCart), HttpStatus.OK);
	}
	
	
	
	
	
}
