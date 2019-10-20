package com.ecommnjt.mapper;



import org.springframework.stereotype.Component;

import com.ecommnjt.dto.CategoryDTO;
import com.ecommnjt.model.Category;

public interface CategoryMapper {
	
	
	CategoryDTO toCategoryDTO(Category category);
	
	Category toCategory(CategoryDTO categoryDTO);
}
