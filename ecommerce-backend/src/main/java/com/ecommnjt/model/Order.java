package com.ecommnjt.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity	
@Table(name = "customerorder")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private int orderId;
	
	@Getter @Setter
	@OneToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "shippingid")
	private ShippingInformation shippingInformation;
	
//	@Getter @Setter
	
//	private Date dateCreated;
	
	@Getter @Setter
	@OneToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "id")
	private User user;
	
	@Getter @Setter
	@OneToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "shoppingcartid")
	private ShoppingCart cart;
}
