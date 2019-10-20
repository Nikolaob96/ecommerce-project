package com.ecommnjt.mapper;

import org.springframework.stereotype.Component;

import com.ecommnjt.dto.MyOrderDTO;
import com.ecommnjt.model.Order;

@Component
public class MyOrderMapperImpl implements MyOrderMapper {

	@Override
	public MyOrderDTO toMyOrderDTO(Order order) {
		MyOrderDTO myOrder = new MyOrderDTO();
		myOrder.setOrderId(order.getOrderId());
		myOrder.setDateCreated(order.getDateCreated());
		myOrder.setShipTo(order.getShippingInformation().getName());
		myOrder.setOrderTotal( order.getTotalPrice());
		myOrder.setOrderStatus(order.getOrderStatus().toString());
		return myOrder;
	}

	@Override
	public Order toOrder(MyOrderDTO myOrderDTO) {
		return null;
	}

}
