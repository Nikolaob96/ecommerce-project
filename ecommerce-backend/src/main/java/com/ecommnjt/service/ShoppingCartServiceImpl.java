package com.ecommnjt.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommnjt.model.ShoppingCart;
import com.ecommnjt.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService {
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	public ShoppingCart createShoppingCart() {
		ShoppingCart sc = new ShoppingCart();
		sc.setDateCreated(new Date());
		return shoppingCartRepository.save(sc);
	}

	public ShoppingCart getShoppingCart(int cartId) {
		return shoppingCartRepository.getOne(cartId);
	}
}
