package com.ecommnjt.service;

import java.util.List;

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
	
	public List<Product> getProducts() {
		return productRepository.findAll();
	}
	
	public Product getProduct(int productID) {
		return productRepository.getOne(productID);
	}
	
	public void updateProduct(Product product) {
		productRepository.save(product);
	}
}
