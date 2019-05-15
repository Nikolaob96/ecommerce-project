package com.ecommnjt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommnjt.model.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

}
