package com.ecommnjt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommnjt.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
