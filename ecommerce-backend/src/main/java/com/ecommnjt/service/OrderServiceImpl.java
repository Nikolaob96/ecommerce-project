package com.ecommnjt.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommnjt.dto.MyOrderDTO;
import com.ecommnjt.dto.OrderDTO;
import com.ecommnjt.dto.OrderReviewDTO;
import com.ecommnjt.mapper.MyOrderMapper;
import com.ecommnjt.mapper.OrderMapper;
import com.ecommnjt.mapper.OrderReviewMapper;
import com.ecommnjt.model.Order;
import com.ecommnjt.model.OrderStatus;
import com.ecommnjt.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private OrderReviewMapper orderReviewMapper;
	
	@Autowired
	private MyOrderMapper myOrderMapper;
	
	@Autowired
	private PayPalServiceImpl paypalService;
	
	public int save(OrderDTO order) {
		Order or = orderMapper.toOrder(order);
		or.setOrderStatus(OrderStatus.PENDING);
		
		orderRepository.save(or);
		return or.getOrderId();
	}


	public List<MyOrderDTO> getOrdersByUser(String username) {
		List<Order> orders = orderRepository.findOrdersByUser(username);
		
		List<MyOrderDTO> myOrders = new ArrayList<>();
		
		for (Order order : orders) {
			myOrders.add(myOrderMapper.toMyOrderDTO(order));
		}
		return myOrders;
	}
	
	public List<MyOrderDTO> getOrders() {
		List<Order> orders = orderRepository.findAll();
		
		List<MyOrderDTO> allOrders = new ArrayList<>();
		
		for (Order order : orders) {
			allOrders.add(myOrderMapper.toMyOrderDTO(order));
		}
		return allOrders;
	}


	public void cancelOrder(int orderId) {
		paypalService.refundPayment(orderId);
		Order order = orderRepository.getOne(orderId);
		order.setOrderStatus(OrderStatus.CANCELLED);
		orderRepository.save(order);		
	}

	public void approveOrder(int orderId) {
		Order order = orderRepository.getOne(orderId);
		order.setOrderStatus(OrderStatus.SHIPPED);
		orderRepository.save(order);		
	}
	
	@Override
	public OrderReviewDTO getOrderById(int id) {
		Optional<Order> o = orderRepository.findOrderById(id);
		
		OrderReviewDTO orderDTO;
		
		if(o.isPresent()) {
			orderDTO = orderReviewMapper.toOrderReviewDTO(o.get());
		} else {
			orderDTO = new OrderReviewDTO();
		}
		 
		
		return orderDTO;
	}
	
	public Order getOrder(int id) {
		Optional<Order> o = orderRepository.findOrderById(id);
		
		if(o.isPresent()) {
			return o.get();
		}
		return null;
	}
	
	
}
