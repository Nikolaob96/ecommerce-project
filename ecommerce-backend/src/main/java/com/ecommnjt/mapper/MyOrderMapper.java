package com.ecommnjt.mapper;

import com.ecommnjt.dto.CategoryDTO;
import com.ecommnjt.dto.MyOrderDTO;
import com.ecommnjt.model.Category;
import com.ecommnjt.model.Order;

public interface MyOrderMapper {
	
	MyOrderDTO toMyOrderDTO(Order order);
	
	Order toOrder(MyOrderDTO myOrderDTO);
}
