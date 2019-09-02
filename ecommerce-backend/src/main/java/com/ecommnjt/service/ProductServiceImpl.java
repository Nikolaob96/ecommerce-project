package com.ecommnjt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommnjt.model.Category;
import com.ecommnjt.model.Product;
import com.ecommnjt.repository.CategoryRepository;
import com.ecommnjt.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	
	public List<Product> getProducts() {
		return productRepository.findAll();
	}
	
	public Product getProduct(int productID) {
		return productRepository.getOne(productID);
	}
	
	public Product updateProduct(Product product) {
		if(product.getCategory().getId() == 0) {
			Category category = categoryRepository.findByName(product.getCategory().getName());
			product.setCategory(category);
		}
		return productRepository.save(product);
	}
	
	public void delete(int productId) {
		productRepository.deleteById(productId);
	}
}
