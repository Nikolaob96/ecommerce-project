package com.ecommnjt.service;

import java.util.List;

import com.ecommnjt.dto.CategoryDTO;
import com.ecommnjt.model.Category;

public interface CategoryService {
	
	public List<CategoryDTO> getAll();
	public Category findByName(String name);
	public CategoryDTO getCategory(int id);
	public void delete(int id);
	public void addCategory(CategoryDTO categoryDTO);
	
}
