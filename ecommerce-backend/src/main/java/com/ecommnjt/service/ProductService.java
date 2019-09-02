package com.ecommnjt.service;

import java.util.List;

import com.ecommnjt.model.Product;

public interface ProductService {

	public void addProduct(Product product);
	public List<Product> getProducts();
	public Product getProduct(int productID);
	public Product updateProduct(Product product);
	public void delete(int productId);
}
