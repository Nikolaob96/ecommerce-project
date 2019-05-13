package com.ecommnjt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommnjt.model.Product;
import com.ecommnjt.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public void addProduct(Product product) {
		productRepository.save(product);
	}
}
