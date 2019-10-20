package com.ecommnjt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommnjt.dto.ShoppingCartItemDTO;
import com.ecommnjt.mapper.ShoppingCartItemMapper;
import com.ecommnjt.model.ShoppingCartItem;
import com.ecommnjt.repository.ShoppingCartItemRepository;

@Service
public class ShoppingCartItemServiceImpl implements ShoppingCartItemService{
	
	@Autowired
	private ShoppingCartItemRepository cartRepository;
	
	@Autowired
	private ShoppingCartItemMapper shoppingCartItemMapper;
	
	public ShoppingCartItemDTO getCartItem(int cartId, int productId) {
		Optional<ShoppingCartItem> cartItem = cartRepository.findByCartAndProduct(cartId, productId);
		
		ShoppingCartItem shoppingCartItem = null;
		if(cartItem.isPresent()) {
			shoppingCartItem = cartItem.get();
		}
		return shoppingCartItemMapper.toShoppingCartItemDTO(shoppingCartItem);
	}

	public void update(ShoppingCartItemDTO cartItem) {
		cartRepository.save(shoppingCartItemMapper.toShoppingCartItem(cartItem));
		
	}
	
	public void save(ShoppingCartItemDTO cartItem) {
		cartRepository.saveCartItem(cartItem.getId(), cartItem.getProductId(), cartItem.getShoppingCartId(), cartItem.getQuantity());
	}

	public ShoppingCartItemDTO getItem(int id) {
		Optional<ShoppingCartItem> cartItem = cartRepository.findById(id);
		
		ShoppingCartItem shoppingCartItem = null;
		if(cartItem.isPresent()) {
			shoppingCartItem = cartItem.get();
		}
		return shoppingCartItemMapper.toShoppingCartItemDTO(shoppingCartItem);
	}
	
	@Transactional
	public void clearShoppingCart(int cartId) {
		cartRepository.clearCart(cartId);
		
	}
	
	@Transactional
	public void deleteItem(int cartId, int productId) {
		cartRepository.deleteItem(cartId, productId);
		
	}

	public void saveItems(List<ShoppingCartItemDTO> cartItems, int id) {
		for(ShoppingCartItemDTO cartItem : cartItems) {
			cartRepository.saveCartItem(0, cartItem.getId(), id, cartItem.getQuantity());
		}
		
	}

	

	
}
