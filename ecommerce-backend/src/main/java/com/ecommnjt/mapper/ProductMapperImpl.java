package com.ecommnjt.mapper;

import org.springframework.stereotype.Component;

import com.ecommnjt.dto.ProductDTO;
import com.ecommnjt.model.Category;
import com.ecommnjt.model.Product;

@Component
public class ProductMapperImpl implements ProductMapper {

	@Override
	public ProductDTO toProductDTO(Product product) {
		
		ProductDTO productDTO = new ProductDTO();
		
		if(product.getId() != 0) {
			productDTO.setId(product.getId());
			productDTO.setName(product.getName());
			productDTO.setDescription(product.getDescription());
			productDTO.setPrice(product.getPrice());
			productDTO.setImage(product.getImage());
			productDTO.setCategory(product.getCategory().getName());
			return productDTO;
		} else {
			return productDTO;
		}
		
	}

	@Override
	public Product toProduct(ProductDTO productDTO) {
		return new Product(productDTO.getId(),productDTO.getName(),productDTO.getDescription(),productDTO.getPrice(),productDTO.getImage(), new Category(0, productDTO.getCategory()));
	}

}
