package com.ecommnjt.service;

import java.util.List;

import com.ecommnjt.model.Category;

public interface CategoryService {
	
	public List<Category> getAll();
	public Category findByName(String name);
	
}
