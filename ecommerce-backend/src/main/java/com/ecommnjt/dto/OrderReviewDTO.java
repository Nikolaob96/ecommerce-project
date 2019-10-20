package com.ecommnjt.dto;

import java.util.Date;

import com.ecommnjt.model.Order;
import com.ecommnjt.model.OrderStatus;
import com.ecommnjt.model.ShippingInformation;
import com.ecommnjt.model.ShoppingCart;
import com.ecommnjt.model.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class OrderReviewDTO {
	@Getter @Setter
	private int orderId;
	@Getter @Setter
	private ShippingInformation shippingInformation;
	@Getter @Setter
	private Date dateCreated;
	@Getter @Setter
	private ShoppingCart shoppingCart;
	@Getter @Setter
	private int totalPrice;
	@Getter @Setter
	private String orderStatus;
	
//	public OrderReviewDTO(Order order) {
//		if(order.getOrderId() != 0) {
//			this.orderId = order.getOrderId();
//		}
//		this.shippingInformation = order.getShippingInformation();
//		this.dateCreated = order.getDateCreated();
//		this.shoppingCart = order.getCart();
//		this.totalPrice = order.getTotalPrice();
//		this.orderStatus = order.getOrderStatus().toString();
//	}
//	
//	public static Order getOrder(OrderReviewDTO orderDTO) {
//		return new Order(orderDTO.getOrderId(), orderDTO.getShippingInformation(), orderDTO.getDateCreated(), null, orderDTO.getShoppingCart(), orderDTO.getTotalPrice(), OrderStatus.PENDING);
//	}
//	
}
