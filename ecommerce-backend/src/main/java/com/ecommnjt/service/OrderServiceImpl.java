package com.ecommnjt.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommnjt.dto.MyOrderDTO;
import com.ecommnjt.dto.OrderDTO;
import com.ecommnjt.model.Order;
import com.ecommnjt.model.OrderStatus;
import com.ecommnjt.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	
	public int save(OrderDTO order) {
		Order or = order.getOrder(order);
		or.setOrderStatus(OrderStatus.CANCELLED);
		orderRepository.save(or);
		return or.getOrderId();
	}


	public List<MyOrderDTO> getOrdersByUser(String username) {
		List<Order> orders = orderRepository.findOrdersByUser(username);
		
		List<MyOrderDTO> myOrders = new ArrayList<>();
		
		for (Order order : orders) {
			myOrders.add(new MyOrderDTO(order));
		}
		return myOrders;
	}
	
	public List<MyOrderDTO> getOrders() {
		List<Order> orders = orderRepository.findAll();
		
		List<MyOrderDTO> allOrders = new ArrayList<>();
		
		for (Order order : orders) {
			allOrders.add(new MyOrderDTO(order));
		}
		return allOrders;
	}


	public void cancelOrder(int orderId) {
		Order order = orderRepository.getOne(orderId);
		order.setOrderStatus(OrderStatus.CANCELLED);
		orderRepository.save(order);
		
		
	}
}
