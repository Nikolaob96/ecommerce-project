package com.ecommnjt.mapper;

import org.springframework.stereotype.Component;

import com.ecommnjt.dto.CategoryDTO;
import com.ecommnjt.model.Category;

@Component
public class CategoryMapperImpl implements CategoryMapper {

	@Override
	public CategoryDTO toCategoryDTO(Category category) {
		
		CategoryDTO categoryDTO = new CategoryDTO();
		
		if(category.getId() != 0) {
			categoryDTO.setId(category.getId());
			categoryDTO.setName(category.getName());
			return categoryDTO;
		} else {
			return categoryDTO;
		}
	}

	@Override
	public Category toCategory(CategoryDTO categoryDTO) {
		Category category = new Category();
		
		category.setId(categoryDTO.getId());
		category.setName(categoryDTO.getName());
		
		return category;
	}
	
}
