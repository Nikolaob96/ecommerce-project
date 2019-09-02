package com.ecommnjt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommnjt.dto.CategoryDTO;
import com.ecommnjt.model.Category;
import com.ecommnjt.service.CategoryServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

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
		List<Category> categories = categoryService.getAll();
		
		List<CategoryDTO> listOfCategories = new ArrayList<>();
		
		for(Category category : categories) {
			listOfCategories.add(new CategoryDTO(category));
		}
		return new ResponseEntity<>(listOfCategories,HttpStatus.OK);
	}
}
