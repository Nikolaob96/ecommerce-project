package com.ecommnjt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommnjt.dto.MyOrderDTO;
import com.ecommnjt.dto.OrderDTO;
import com.ecommnjt.service.OrderServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class OrderController {
	
	@Autowired
	private OrderServiceImpl orderService;
	
	@RequestMapping(value = "/orders", method = RequestMethod.POST)
	@ApiOperation(value = "Saves the customers order",
	notes = "When the order gets saved, its identification number gets retured in the response entity.",
	response = Integer.class)
	@ApiResponse(code = 200, message = "Ok")
	private ResponseEntity<Integer> save(@RequestBody OrderDTO orderDTO) {
		int orderId = orderService.save(orderDTO);
		return new ResponseEntity<Integer>(orderId, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/orders/{username}", method = RequestMethod.GET)
	@ApiOperation(value = "Finds all orders made by the specific user",
	notes = "Returns collection of orders of a cartain customer in the response",
	response = OrderDTO.class, responseContainer = "List")
	@ApiResponse(code = 200, message = "Ok")
	private ResponseEntity<List<MyOrderDTO>> findOrdersByUser(
			@ApiParam(name = "username", value = "username of a specific user", required = true) @PathVariable String username) {
		List<MyOrderDTO> ordersList = orderService.getOrdersByUser(username);
		
		return new ResponseEntity<List<MyOrderDTO>>(ordersList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	@ApiOperation(value = "Returns all existing orders",
	notes = "TO DO...",
	response = OrderDTO.class, responseContainer = "List")
	@ApiResponse(code = 200, message = "Ok")
	private ResponseEntity<List<MyOrderDTO>> getOrders() {
		List<MyOrderDTO> ordersList = orderService.getOrders();
		
		return new ResponseEntity<List<MyOrderDTO>>(ordersList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/orders", method = RequestMethod.PUT)
	@ApiOperation(value = "Cancel specific order",
	notes = "Updates the order status to CANCELLED")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request") })
	private ResponseEntity<Void> cancelOrder(
			@ApiParam(name = "id", value = "id of a specific order", required = true) @RequestBody int orderId) {
		
		if(orderId == 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		orderService.cancelOrder(orderId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
