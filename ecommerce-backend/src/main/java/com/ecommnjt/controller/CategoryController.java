package com.ecommnjt.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommnjt.dto.CategoryDTO;
import com.ecommnjt.dto.ProductDTO;
import com.ecommnjt.mapper.CategoryMapper;
import com.ecommnjt.mapper.CategoryMapperImpl;
import com.ecommnjt.model.Category;
import com.ecommnjt.model.Product;
import com.ecommnjt.service.CategoryServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CategoryController {
	
	@Autowired
	private CategoryServiceImpl categoryService;
	
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	@ApiOperation(value = "Returns all existing categories of the products",
			notes = "TO DO...",
			response = CategoryDTO.class, responseContainer = "List")
	@ApiResponse(code = 200, message = "Ok")
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	private ResponseEntity<List<CategoryDTO>> getAll() {
		List<CategoryDTO> listOfCategories = categoryService.getAll();
		
		return new ResponseEntity<>(listOfCategories,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Returns a category with specific id",
	notes = "TO DO...",
	response = CategoryDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = CategoryDTO.class),
			@ApiResponse(code = 404, message = "Not found") })
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public ResponseEntity<CategoryDTO> getCategoryById(
			@ApiParam(value = "The ID of a category.", required = true)  @PathVariable int id) {
		
		CategoryDTO category = categoryService.getCategory(id);
		
		if(category == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(category, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/categories", method = RequestMethod.POST)
	@ApiOperation(value = "Adds a new category",
	notes = "TO DO...",
	response = CategoryDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = CategoryDTO.class),
			@ApiResponse(code = 500, message = "Failure"), @ApiResponse(code = 400, message = "Bad request") })
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public ResponseEntity<CategoryDTO> addCategories(
			@ApiParam(value = "The categoryDTO object", required = true) @RequestBody CategoryDTO categoryDTO) {
		
		if(categoryDTO == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		categoryService.addCategory(categoryDTO);
		
		return new ResponseEntity<>(categoryDTO,HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/categories/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete a category.", httpMethod = "DELETE")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 400, message = "Bad request") })
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public ResponseEntity<Void> deleteCategory(
			@ApiParam(name = "id", value = "id of a category to delete", required = true) @PathVariable int id) {
		
		if(id == 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		categoryService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
