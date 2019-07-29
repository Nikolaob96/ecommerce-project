package com.ecommnjt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommnjt.dto.OrderDTO;
import com.ecommnjt.model.Order;
import com.ecommnjt.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	
	public int save(OrderDTO order) {
		Order or = order.getOrder(order);
		orderRepository.save(or);
		return or.getOrderId();
	}
}
