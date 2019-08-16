package com.ecommnjt.service;

import com.ecommnjt.model.ShoppingCart;

public interface ShoppingCartService {
	
	public ShoppingCart createShoppingCart();
	public ShoppingCart getShoppingCart(int cartId);
	
}
