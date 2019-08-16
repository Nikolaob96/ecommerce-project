package com.ecommnjt.service;

import com.ecommnjt.dto.ShoppingCartItemDTO;

public interface ShoppingCartItemService {
	
	public ShoppingCartItemDTO getCartItem(int cartId, int productId);
	public void update(ShoppingCartItemDTO cartItem);
	public void save(ShoppingCartItemDTO cartItem);
	public ShoppingCartItemDTO getItem(int id);
	public void clearShoppingCart(int cartId);
	public void deleteItem(int cartId, int productId);
}
