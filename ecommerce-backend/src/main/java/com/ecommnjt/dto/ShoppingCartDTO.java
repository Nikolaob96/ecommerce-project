package com.ecommnjt.dto;

import java.util.Date;
import java.util.List;

import com.ecommnjt.model.ShoppingCart;
import com.ecommnjt.model.ShoppingCartItem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartDTO {
	
	@Getter @Setter
	private int id;
	@Getter @Setter
	private Date dateCreated;
	@Getter @Setter
	private List<ShoppingCartItem> items;
	
//	public ShoppingCartDTO(ShoppingCart shoppingCart) {
//		if(shoppingCart.getId() != 0) {
//			this.id = shoppingCart.getId();
//		}
//		this.dateCreated = shoppingCart.getDateCreated();
//		this.items = shoppingCart.getCartItem();
//	}
//	
//	public ShoppingCart getShoppingCart(ShoppingCartDTO shoppingCartDTO) {
//		return new ShoppingCart(shoppingCartDTO.getId(), shoppingCartDTO.getDateCreated(), shoppingCartDTO.getItems());
//	}
}
