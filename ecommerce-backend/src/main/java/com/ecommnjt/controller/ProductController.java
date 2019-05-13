package com.ecommnjt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommnjt.dto.ProductDTO;
import com.ecommnjt.service.ProductService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/addProducts")
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public void addProducts(@RequestBody ProductDTO productDTO) {
		productService.addProduct(ProductDTO.getProduct(productDTO));
	}
}
