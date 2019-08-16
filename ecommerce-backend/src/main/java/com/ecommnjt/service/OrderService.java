package com.ecommnjt.service;

import java.util.List;

import com.ecommnjt.dto.MyOrderDTO;
import com.ecommnjt.dto.OrderDTO;

public interface OrderService {
	
	public int save(OrderDTO order);
	public List<MyOrderDTO> getOrdersByUser(String username);
	public List<MyOrderDTO> getOrders();
	
}
