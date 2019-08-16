package com.ecommnjt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommnjt.dto.ProductDTO;
import com.ecommnjt.model.Category;
import com.ecommnjt.model.Product;
import com.ecommnjt.service.CategoryServiceImpl;
import com.ecommnjt.service.ProductServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productService;
	
	@Autowired
	private CategoryServiceImpl categoryService;
	
	@PostMapping("/addProducts")
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public void addProducts(@RequestBody ProductDTO productDTO) {
		Category category = categoryService.findByName(productDTO.getCategory());
		
		Product product = ProductDTO.getProduct(productDTO);
		product.setCategory(category);
		productService.addProduct(product);
	}
	
	@GetMapping("/getProducts")
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public ResponseEntity<List<ProductDTO>> getProducts() {
		List<Product> products = productService.getProducts();
		List<ProductDTO> productsDTO = new ArrayList<>();
		
		for (Product product : products) {
			productsDTO.add(new ProductDTO(product));
		}
		
		return new ResponseEntity<>(productsDTO,HttpStatus.OK);
	}
	
	@GetMapping("/Products/{productID}")
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public ResponseEntity<ProductDTO> getProduct(@PathVariable int productID) {
		return new ResponseEntity<>(new ProductDTO(productService.getProduct(productID)),HttpStatus.OK);
	}
	
	@PutMapping("/Products")
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public void updateProduct(@RequestBody ProductDTO productDTO) {
		productService.updateProduct(ProductDTO.getProduct(productDTO));
	}
	
	@DeleteMapping("/Products/{productId}")
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public void deleteProduct(@PathVariable int productId) {
		productService.delete(productId);
	}
	
}
