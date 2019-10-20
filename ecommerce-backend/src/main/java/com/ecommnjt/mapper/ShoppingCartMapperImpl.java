package com.ecommnjt.mapper;

import org.springframework.stereotype.Component;

import com.ecommnjt.dto.ShoppingCartDTO;
import com.ecommnjt.model.ShoppingCart;

@Component
public class ShoppingCartMapperImpl implements ShoppingCartMapper {

	@Override
	public ShoppingCartDTO toShoppingCartDTO(ShoppingCart shoppingCart) {
		ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();
		
		if(shoppingCart.getId() != 0) {
			shoppingCartDTO.setId(shoppingCart.getId());
			shoppingCartDTO.setDateCreated(shoppingCart.getDateCreated());
			shoppingCartDTO.setItems(shoppingCart.getCartItem());
			return shoppingCartDTO;
		} else {
			return shoppingCartDTO;
		}
		
	}

	@Override
	public ShoppingCart toShoppingCart(ShoppingCartDTO shoppingCartDTO) {
		return new ShoppingCart(shoppingCartDTO.getId(), shoppingCartDTO.getDateCreated(), shoppingCartDTO.getItems());
	}

}
