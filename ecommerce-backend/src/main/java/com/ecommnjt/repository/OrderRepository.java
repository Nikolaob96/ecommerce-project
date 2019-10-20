package com.ecommnjt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommnjt.model.Order;
import com.ecommnjt.model.ShoppingCartItem;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Query("select s from Order s where user.username=?1")
	List<Order> findOrdersByUser(@Param("username") String username);
	
	@Query("select s from Order s where orderId=?1")
	Optional<Order> findOrderById(@Param("orderId") int id);
	
}
