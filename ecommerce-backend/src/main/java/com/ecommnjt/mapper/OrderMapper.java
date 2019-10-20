package com.ecommnjt.mapper;

import com.ecommnjt.dto.CategoryDTO;
import com.ecommnjt.dto.OrderDTO;
import com.ecommnjt.model.Category;
import com.ecommnjt.model.Order;

public interface OrderMapper {
	
	OrderDTO toOrderDTO(Order order);
	
	Order toOrder(OrderDTO orderDTO);
}
