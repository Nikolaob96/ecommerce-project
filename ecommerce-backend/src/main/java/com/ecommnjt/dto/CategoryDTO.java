 package com.ecommnjt.dto;

import com.ecommnjt.model.Category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class CategoryDTO {

	@Getter @Setter
	private int id;
	@Getter @Setter
	private String name;
	
//	public CategoryDTO(Category category) {
//		if(category.getId() != 0) {
//			this.id = category.getId();
//		}
//		this.name = category.getName();
//	}
//	
//	public static Category getCategory(CategoryDTO categoryDTO) {
//		return new Category(categoryDTO.getId(),categoryDTO.getName());
//	}
}
