package com.ecommnjt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommnjt.dto.MyOrderDTO;
import com.ecommnjt.dto.OrderDTO;
import com.ecommnjt.service.OrderService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/Orders")
	private ResponseEntity<Integer> saveOrder(@RequestBody OrderDTO orderDTO) {
		int orderId = orderService.save(orderDTO);
		return new ResponseEntity<Integer>(orderId, HttpStatus.OK);
	}
	
	@GetMapping("/Orders/{username}")
	private ResponseEntity<List<MyOrderDTO>> getOrdersByUser(@PathVariable String username) {
		List<MyOrderDTO> ordersList = orderService.getOrdersByUser(username);

		return new ResponseEntity<List<MyOrderDTO>>(ordersList, HttpStatus.OK);
	}
	
	@GetMapping("/Orders")
	private ResponseEntity<List<MyOrderDTO>> getOrders() {
		List<MyOrderDTO> ordersList = orderService.getOrders();
		
		return new ResponseEntity<List<MyOrderDTO>>(ordersList, HttpStatus.OK);
	}
}
