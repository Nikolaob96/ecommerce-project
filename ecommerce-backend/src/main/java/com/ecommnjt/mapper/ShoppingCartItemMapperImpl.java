package com.ecommnjt.mapper;

import org.springframework.stereotype.Component;

import com.ecommnjt.dto.ShoppingCartItemDTO;
import com.ecommnjt.model.Product;
import com.ecommnjt.model.ShoppingCart;
import com.ecommnjt.model.ShoppingCartItem;

@Component
public class ShoppingCartItemMapperImpl implements ShoppingCartItemMapper {

	@Override
	public ShoppingCartItemDTO toShoppingCartItemDTO(ShoppingCartItem shoppingCartItem) {
		ShoppingCartItemDTO shoppingCartItemDTO = new ShoppingCartItemDTO();
		if(shoppingCartItem != null) {
			
			if(shoppingCartItem.getId() != 0) {
				shoppingCartItemDTO.setId(shoppingCartItem.getId());
				shoppingCartItemDTO.setProductId(shoppingCartItem.getProduct().getId());
				shoppingCartItemDTO.setShoppingCartId(shoppingCartItem.getId());
				shoppingCartItemDTO.setQuantity(shoppingCartItem.getQuantity());
				return shoppingCartItemDTO;
				}
			} 
		return shoppingCartItemDTO;
	}

	@Override
	public ShoppingCartItem toShoppingCartItem(ShoppingCartItemDTO dto) {
		return new ShoppingCartItem(dto.getId(),new Product(dto.getProductId(), null, null, 0, null, null), new ShoppingCart(dto.getShoppingCartId(), null, null), dto.getQuantity());
	}

}
