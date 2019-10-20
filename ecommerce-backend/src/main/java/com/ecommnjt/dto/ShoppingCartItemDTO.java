package com.ecommnjt.dto;

import com.ecommnjt.model.Product;
import com.ecommnjt.model.ShoppingCart;
import com.ecommnjt.model.ShoppingCartItem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartItemDTO {
	
	@Getter @Setter
	private int id;
	@Getter @Setter
	private int productId;
	@Getter @Setter
	private int shoppingCartId;
	@Getter @Setter
	private int quantity;
	
//	public ShoppingCartItemDTO (ShoppingCartItem shoppingCartItem) {
//		if(shoppingCartItem != null) {
//		
//		if(shoppingCartItem.getId() != 0) {
//			this.id = shoppingCartItem.getId();
//		}
//		this.productId = shoppingCartItem.getProduct().getId();
//		this.shoppingCartId = shoppingCartItem.getId();
//		this.quantity = shoppingCartItem.getQuantity();
//		} 
//	}
//	
//	public static ShoppingCartItem getItem(ShoppingCartItemDTO dto) {
//		return new ShoppingCartItem(dto.getId(),new Product(dto.getProductId(), null, null, 0, null, null), new ShoppingCart(dto.getShoppingCartId(), null, null), dto.getQuantity());
//	}
}
