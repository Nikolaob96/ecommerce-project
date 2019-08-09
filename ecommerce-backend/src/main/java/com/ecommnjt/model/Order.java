package com.ecommnjt.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	@Column(name="orderid")
	private int orderId;
	
	@Getter @Setter
	@OneToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "shippingid")
	private ShippingInformation shippingInformation;
	
	@Getter @Setter
	@Column(name="datecreated")
    private Date dateCreated;
	
	@Getter @Setter
	@OneToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "id")
	private User user;
	
	@Getter @Setter
	@OneToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "shoppingcartid")
	private ShoppingCart cart;
	
	@Getter @Setter
	@Column(name="totalprice")
	private int totalPrice;
	
	@Getter @Setter
	@Column(name = "orderstatus")
	private OrderStatus orderStatus;
}
