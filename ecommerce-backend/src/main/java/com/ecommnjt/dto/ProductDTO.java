package com.ecommnjt.dto;


import com.ecommnjt.model.Category;
import com.ecommnjt.model.Product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class ProductDTO {
	
	@Getter @Setter
	private int id;
	@Getter @Setter
	private String name;
	@Getter @Setter
	private String description;
	@Getter @Setter
	private int price;
	@Getter @Setter
	private String image;
	@Getter @Setter
	private String category;
	
	public ProductDTO(Product product) {
		if(product.getId() != 0) {
			this.id = product.getId();
		}
		this.name = product.getName();
		this.description = product.getDescription();
		this.price = product.getPrice();
		this.image = product.getImage();
		this.category = product.getCategory().getName();
	}
	
	public static Product getProduct(ProductDTO productDTO) {
		return new Product(productDTO.getId(),productDTO.getName(),productDTO.getDescription(),productDTO.getPrice(),productDTO.getImage(), new Category(0, productDTO.getCategory()));
	}
	
}
