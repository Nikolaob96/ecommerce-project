package com.ecommnjt.mapper;

import com.ecommnjt.dto.CategoryDTO;
import com.ecommnjt.dto.OrderReviewDTO;
import com.ecommnjt.model.Category;
import com.ecommnjt.model.Order;

public interface OrderReviewMapper {
	
	OrderReviewDTO toOrderReviewDTO(Order order);
	
	Order toOrderReview(OrderReviewDTO orderReviewDTO);

}
