package com.ecommnjt.mapper;

import org.springframework.stereotype.Component;

import com.ecommnjt.dto.OrderReviewDTO;
import com.ecommnjt.model.Order;
import com.ecommnjt.model.OrderStatus;

@Component
public class OrderReviewMapperImpl implements OrderReviewMapper {

	@Override
	public OrderReviewDTO toOrderReviewDTO(Order order) {
		OrderReviewDTO orderReviewDTO = new OrderReviewDTO();
		if(order.getOrderId() != 0) {
			orderReviewDTO.setOrderId(order.getOrderId());
			orderReviewDTO.setShippingInformation(order.getShippingInformation());
			orderReviewDTO.setDateCreated(order.getDateCreated());
			orderReviewDTO.setShoppingCart(order.getCart());
			orderReviewDTO.setTotalPrice(order.getTotalPrice());
			orderReviewDTO.setOrderStatus(order.getOrderStatus().toString());
			return orderReviewDTO;
		} else {
			return orderReviewDTO;
		}
	}

	@Override
	public Order toOrderReview(OrderReviewDTO orderDTO) {
		return new Order(orderDTO.getOrderId(), orderDTO.getShippingInformation(), orderDTO.getDateCreated(), null, orderDTO.getShoppingCart(), orderDTO.getTotalPrice(), OrderStatus.PENDING);
	}

}
