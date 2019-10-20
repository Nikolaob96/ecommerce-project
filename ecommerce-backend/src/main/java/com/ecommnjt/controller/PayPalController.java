package com.ecommnjt.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommnjt.dto.OrderDTO;
import com.ecommnjt.service.PayPalServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class PayPalController {
	
	@Autowired
	private PayPalServiceImpl payPalService;

	@RequestMapping(value = "/payments", method = RequestMethod.POST)
	@ApiOperation(value = "Creates new payment",
	notes = "")
	@ApiResponse(code = 200, message = "Ok")
	private ResponseEntity<Map<String, Object>> save(@RequestBody String sum) {
		return new ResponseEntity<>(payPalService.createPayment(sum), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/payments/complete", method = RequestMethod.POST)
	@ApiOperation(value = "Confirms the payment",
	notes = "")
	@ApiResponse(code = 200, message = "Ok")
	private ResponseEntity<Void> complete(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId, @RequestParam("OrderId") int orderId) {
		Map<String, Object> map = payPalService.completePayment(paymentId, payerId, orderId);
		if(map.get("status").equals("success")) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/payments/refund", method = RequestMethod.POST)
	@ApiOperation(value = "Refunds the payment",
	notes = "")
	@ApiResponse(code = 200, message = "Ok")
	private ResponseEntity<Void> refund(@RequestParam("OrderId") int orderId) {
		Map<String, Object> map = payPalService.refundPayment(orderId);
		if(map.get("status").equals("success")) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
