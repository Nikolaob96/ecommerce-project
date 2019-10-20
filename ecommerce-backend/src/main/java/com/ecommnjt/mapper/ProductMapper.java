package com.ecommnjt.mapper;

import com.ecommnjt.dto.ProductDTO;
import com.ecommnjt.model.Product;

public interface ProductMapper {
	
	ProductDTO toProductDTO(Product product);
	
	Product toProduct(ProductDTO productDTO);
}
