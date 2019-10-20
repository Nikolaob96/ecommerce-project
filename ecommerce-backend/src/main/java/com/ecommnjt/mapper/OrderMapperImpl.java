package com.ecommnjt.mapper;

import org.springframework.stereotype.Component;

import com.ecommnjt.dto.OrderDTO;
import com.ecommnjt.model.Order;
import com.ecommnjt.model.OrderStatus;

@Component
public class OrderMapperImpl implements OrderMapper{

	@Override
	public OrderDTO toOrderDTO(Order order) {
		OrderDTO orderDTO = new OrderDTO();
		if(order.getOrderId() != 0) {
			orderDTO.setOrderId(order.getOrderId());
			orderDTO.setShippingInformation(order.getShippingInformation());
			orderDTO.setDateCreated(order.getDateCreated());
			orderDTO.setUser(order.getUser());
			orderDTO.setShoppingCart(order.getCart());
			orderDTO.setTotalPrice(order.getTotalPrice());
			orderDTO.setOrderStatus(order.getOrderStatus().toString());
			return orderDTO;
		} else {
			return orderDTO;
		}
	}

	@Override
	public Order toOrder(OrderDTO orderDTO) {
		return new Order(orderDTO.getOrderId(), orderDTO.getShippingInformation(), orderDTO.getDateCreated(), orderDTO.getUser(), orderDTO.getShoppingCart(), orderDTO.getTotalPrice(), OrderStatus.PENDING);
	}

}
