package com.ecommnjt.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="shoppingcartitem")
public class ShoppingCartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private int id;
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name="productid")
	private Product product;
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name="shoppingcartid")
	@JsonIgnore
	private ShoppingCart shoppingCart;
	@Getter @Setter
	private int quantity;
}
