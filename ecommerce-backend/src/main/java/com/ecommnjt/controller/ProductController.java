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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.ecommnjt.dto.ProductDTO;
import com.ecommnjt.model.Category;
import com.ecommnjt.model.Product;
import com.ecommnjt.service.CategoryServiceImpl;
import com.ecommnjt.service.ProductServiceImpl;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productService;
	
	@Autowired
	private CategoryServiceImpl categoryService;
	
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	@ApiOperation(value = "Adds a new product",
	notes = "TO DO...",
	response = ProductDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ProductDTO.class),
			@ApiResponse(code = 500, message = "Failure"), @ApiResponse(code = 400, message = "Bad request") })
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public ResponseEntity<ProductDTO> addProducts(
			@ApiParam(value = "The productDTO object", required = true) @RequestBody ProductDTO productDTO) {
		
		if(productDTO == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Category category = categoryService.findByName(productDTO.getCategory());
		
		Product product = ProductDTO.getProduct(productDTO);
		product.setCategory(category);
		productService.addProduct(product);
		
		return new ResponseEntity<>(productDTO,HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	@ApiOperation(value = "Returns all existing products",
	notes = "TO DO...",
	response = ProductDTO.class, responseContainer = "List")
	@ApiResponse(code = 200, message = "Ok")
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public ResponseEntity<List<ProductDTO>> getProducts() {
		List<Product> products = productService.getProducts();
		List<ProductDTO> productsDTO = new ArrayList<>();
		
		for (Product product : products) {
			productsDTO.add(new ProductDTO(product));
		}
		
		return new ResponseEntity<>(productsDTO,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/products/{productID}", method = RequestMethod.GET)
	@ApiOperation(value = "Returns a product with specific id",
	notes = "TO DO...",
	response = ProductDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ProductDTO.class),
			@ApiResponse(code = 404, message = "Not found") })
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public ResponseEntity<ProductDTO> getProductById(
			@ApiParam(value = "The ID of a product.", required = true)  @PathVariable int productID) {
		
		Product product = productService.getProduct(productID);
		
		if(product == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		ProductDTO productDTO = new ProductDTO(product);
		
		return new ResponseEntity<>(productDTO, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.PUT)
	@ApiOperation(value = "Update a specific product")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ProductDTO.class),
			@ApiResponse(code = 500, message = "Failure"), @ApiResponse(code = 400, message = "Bad request") })
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public ResponseEntity<ProductDTO> updateProduct(
			@ApiParam(name = "product", value = "product to update", required = true) @RequestBody ProductDTO productDTO) {
		
		if(productDTO == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Product product = productService.updateProduct(ProductDTO.getProduct(productDTO));
		
		ProductDTO pDTO = new ProductDTO(product);
		return new ResponseEntity<>(pDTO, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/products/{productId}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete a product.", httpMethod = "DELETE")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 400, message = "Bad request") })
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public ResponseEntity<Void> deleteProduct(
			@ApiParam(name = "productId", value = "id of a product to delete", required = true) @PathVariable int productId) {
		
		if(productId == 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		productService.delete(productId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
