package com.ecommnjt.mapper;

import com.ecommnjt.dto.ProductDTO;
import com.ecommnjt.dto.ShoppingCartItemDTO;
import com.ecommnjt.model.Product;
import com.ecommnjt.model.ShoppingCartItem;

public interface ShoppingCartItemMapper {
	ShoppingCartItemDTO toShoppingCartItemDTO(ShoppingCartItem shoppingCartItem);
	
	ShoppingCartItem toShoppingCartItem(ShoppingCartItemDTO shoppingCartItemDTO);
}
