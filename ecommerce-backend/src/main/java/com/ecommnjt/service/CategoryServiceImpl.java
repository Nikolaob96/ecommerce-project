package com.ecommnjt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommnjt.dto.CategoryDTO;
import com.ecommnjt.mapper.CategoryMapperImpl;
import com.ecommnjt.model.Category;
import com.ecommnjt.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryMapperImpl categoryMapper;
	
	public List<CategoryDTO> getAll() {
		List<CategoryDTO> listOfCategories = new ArrayList<>();
		List<Category> categories = categoryRepository.findAll();
		
		for(Category category : categories) {
			listOfCategories.add(categoryMapper.toCategoryDTO(category));
		}
		
		return listOfCategories;
	}
	
	public Category findByName(String name) {
		return categoryRepository.findByName(name);
	}

	public CategoryDTO getCategory(int id) {
		Category category = categoryRepository.getOne(id);
		
		CategoryDTO categoryDTO = categoryMapper.toCategoryDTO(category);
		
		return categoryDTO;
	}

	public void addCategory(CategoryDTO categoryDTO) {
		Category category = categoryMapper.toCategory(categoryDTO);
		
		categoryRepository.save(category);
		
	}

	public void delete(int id) {
		Category cat = categoryRepository.getOne(id);
		
		categoryRepository.delete(cat);
		
	}
}
