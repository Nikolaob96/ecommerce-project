package com.ecommnjt.mapper;

import com.ecommnjt.dto.ShoppingCartDTO;
import com.ecommnjt.model.ShoppingCart;

public interface ShoppingCartMapper {
	
	ShoppingCartDTO toShoppingCartDTO(ShoppingCart shoppingCart);
	
	ShoppingCart toShoppingCart(ShoppingCartDTO shoppingCartDTO);
}
