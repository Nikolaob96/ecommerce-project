package com.ecommnjt.dto;

import java.util.Date;

import com.ecommnjt.model.Order;
import com.ecommnjt.model.OrderStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class MyOrderDTO {
	
	@Getter @Setter
	private int orderId;
	@Getter @Setter
	private Date dateCreated;
	@Getter @Setter
	private String shipTo;
	@Getter @Setter
	private int orderTotal;
	@Getter @Setter
	private OrderStatus orderStatus;
	
	public MyOrderDTO(Order order) {
		this.orderId = order.getOrderId();
		dateCreated = order.getDateCreated();
		this.shipTo = order.getShippingInformation().getName();
		this.orderTotal = order.getTotalPrice();
		this.orderStatus = OrderStatus.PENDING;
	}
}
